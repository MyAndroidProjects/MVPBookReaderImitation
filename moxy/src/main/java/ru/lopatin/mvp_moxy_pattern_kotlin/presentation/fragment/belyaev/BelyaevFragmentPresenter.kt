package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.belyaev

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.*
import ru.lopatin.mvp_moxy_pattern_kotlin.data.repository_gateways.Repository
import ru.lopatin.mvp_moxy_pattern_kotlin.domain.observables.MainActivityObservable
import ru.lopatin.mvp_moxy_pattern_kotlin.domain.use_cases.ConverterTextToStringWithContract
import ru.lopatin.mvp_moxy_pattern_kotlin.presentation.activity.MainActivityFragment

@InjectViewState
class BelyaevFragmentPresenter : MvpPresenter<BelyaevFragmentContractView>(),BelyaevFragmentContract.Presenter,
    ConverterTextToStringWithContract.IConverterContract {

    // родительский Job, нужен для контекста и чтобы закончить разом все корутины, дочерние этому job
    private val parentJob = Job()
    // главный поток приложения
    private val dispatcherMain = Dispatchers.Main
    // Контекст корутины
    private val parentCoroutineContext = dispatcherMain + parentJob
    // Область видимости корутины // замена, например, GlobalScope
    private val parentScope = CoroutineScope(parentCoroutineContext)

    private var pagesQuantity: Int = 0

    private var currentPageIndex = 0

    private val instance = this


    override fun fragmentIsStarting() {
        Log.d("myLog", " fragmentIsStarting ")
        parentScope.launch {
            viewState.showProgressBarFirst(true)
            val model: BelyaevFragmentContract.Model = Repository()
            // при ошибке получения данный выбрасывает ошибку
            try {
                withContext(Dispatchers.Default) {
                    pagesQuantity = getProfDoulPageNumber(model)
                    getPageAndSetToConvert()
                }
            } catch (ex: Exception) {
                Log.d("myLog", " Exception $ex ")
                parentJob.cancel()
            }
        }
    }

    override fun buttonNextPageSelected() {
        Log.d("myLog", " buttonNextPageSelected ")
        currentPageIndex++
        if (currentPageIndex >= pagesQuantity) {
            currentPageIndex = 0
        }
        parentScope.launch {
            // при ошибке получения данный выбрасывает ошибку
            try {
                withContext(Dispatchers.Default) {
                    getPageAndSetToConvert()
                }
            } catch (ex: Exception) {
                Log.d("myLog", " Exception $ex ")
                parentJob.cancel()
            }
        }
    }

    @Throws(Exception::class)
    private suspend fun getPageAndSetToConvert() {
        withContext(Dispatchers.Default) {
            withContext(dispatcherMain) {
                viewState.showProgressBarFirst(true)
            }
            val model: BelyaevFragmentContract.Model = Repository()
            val textPart = getProfDoulPageText(model, currentPageIndex)
            withContext(dispatcherMain) {
                viewState.showProgressBarSecond(true)
            }
            ConverterTextToStringWithContract(textPart, instance)
        }
    }

    override fun buttonBulgakovSelected() {
        MainActivityObservable.setCurrentFragment(MainActivityFragment.BULGAKOV)
        currentPageIndex = 0
    }

    private suspend fun getProfDoulPageNumber(model: BelyaevFragmentContract.Model): Int {
        return model.getProfDoulTextPartsNumber()
    }


    private suspend fun getProfDoulPageText(model: BelyaevFragmentContract.Model, pageIndex: Int): String {
        return model.getTextPartProfessorDoulByIndex(pageIndex)
    }

    override fun getConvertedString(textString: String) {
        Log.d("myLog", " BelyaevFragmentPresenter getConvertedString ")
        viewState.setText(textString)
        viewState.showProgressBarFirst(false)
        viewState.showProgressBarSecond(false)
    }
}