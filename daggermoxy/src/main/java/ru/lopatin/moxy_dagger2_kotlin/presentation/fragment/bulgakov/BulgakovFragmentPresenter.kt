package ru.lopatin.moxy_dagger2_kotlin.presentation.fragment.bulgakov

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.*
import ru.lopatin.moxy_dagger2_kotlin.data.repository_gateways.Repository
import ru.lopatin.moxy_dagger2_kotlin.domain.observables.MainActivityObservable
import ru.lopatin.moxy_dagger2_kotlin.domain.use_cases.ConverterTextToStringWithContract
import ru.lopatin.moxy_dagger2_kotlin.presentation.activity.MainActivityFragment

@InjectViewState
class BulgakovFragmentPresenter : MvpPresenter<BulgakovFragmentContractView>() ,BulgakovFragmentContract.Presenter,
    ConverterTextToStringWithContract.IConverterContract {


    private val parentJob = Job()
    private val dispatcherMain = Dispatchers.Main
    private val parentCoroutineContext = dispatcherMain + parentJob
    private val parentScope = CoroutineScope(parentCoroutineContext)

    private var currentPageIndex = 0
    private var pagesQuantity: Int = 0
    private val instance = this


    override fun fragmentIsStarting() {
        val model: BulgakovFragmentContract.Model = Repository()
        try {
            parentScope.launch {
                viewState.showProgressBarFirst(true)
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
                viewState.showProgressBarFirst(true)
            }
            val model: BulgakovFragmentContract.Model = Repository()
            val textPart = model.getTextPartMasterAndMargaritaByIndex(currentPageIndex)
            withContext(dispatcherMain) {
                viewState.showProgressBarSecond(true)
            }
            ConverterTextToStringWithContract(textPart, instance)
        }
    }

    override fun buttonBelyaevSelected() {
        MainActivityObservable.setCurrentFragment(MainActivityFragment.BELYAEV)
        currentPageIndex = 0
    }


    override fun getConvertedString(textString: String) {
        viewState.showProgressBarFirst(false)
        viewState.showProgressBarSecond(false)
        viewState.setText(textString)
    }
}
