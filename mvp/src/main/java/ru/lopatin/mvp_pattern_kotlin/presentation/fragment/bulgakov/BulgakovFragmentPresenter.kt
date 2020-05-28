package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.bulgakov

import android.util.Log
import kotlinx.coroutines.*
import ru.lopatin.mvp_pattern_kotlin.data.repository_gateways.Repository
import ru.lopatin.mvp_pattern_kotlin.domain.use_cases.ConverterTextToStringWithContract


object BulgakovFragmentPresenter : BulgakovFragmentContract.Presenter,
    ConverterTextToStringWithContract.IConverterContract {

    private var view: BulgakovFragmentContract.View? = null
    private val navigator = BulgakovFragmentNavigator as BulgakovFragmentContract.Navigator

    private val parentJob = Job()
    private val dispatcherMain = Dispatchers.Main
    private val parentCoroutineContext = dispatcherMain + parentJob
    private val parentScope = CoroutineScope(parentCoroutineContext)

    private var currentPageIndex = 0
    private var pagesQuantity: Int = 0
    private val instance = this

    override fun setViewToPresenter(view: BulgakovFragmentContract.View?) {
        this.view = view
    }

    override fun fragmentIsStarting() {
        val model: BulgakovFragmentContract.Model = Repository()
        try {
            parentScope.launch {
                    view?.showProgressBarFirst(true)
                withContext(Dispatchers.Default) {
                    pagesQuantity = model.getMasterAndMargaritaTextPartsNumber()
                }
                getPageAndSetToConvert()
            }
        } catch (ex: Exception) {
            Log.d("myLog", " Exception $ex ")
            parentJob.cancelChildren()
        }
    }

    override fun buttonNextPageSelected() {
        currentPageIndex++
        if (currentPageIndex >= pagesQuantity) {
            currentPageIndex = 0
        }
        try {
            parentScope.launch {
                getPageAndSetToConvert()
            }
        } catch (ex: Exception) {
            Log.d("myLog", " Exception $ex ")
            parentJob.cancelChildren()
        }
    }

    @Throws(Exception::class)
    private suspend fun getPageAndSetToConvert() {
        withContext(Dispatchers.Default) {
            withContext(dispatcherMain) {
                view?.showProgressBarFirst(true)
            }
            val model: BulgakovFragmentContract.Model = Repository()
            val textPart = model.getTextPartMasterAndMargaritaByIndex(currentPageIndex)
            withContext(dispatcherMain) {
                view?.showProgressBarSecond(true)
            }
            ConverterTextToStringWithContract(textPart, instance)
        }
    }

    override fun buttonBelyaevSelected() {
        navigator.createBelyaevFragment()
        navigator.setBelyaevDataInMainActivity()
        currentPageIndex = 0
    }


    override fun getConvertedString(textString: String) {
        view?.showProgressBarFirst(false)
        view?.showProgressBarSecond(false)
        view?.setText(textString)
    }
}
