package ru.lopatin.moxy_dagger2_kotlin.presentation.activity

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import ru.lopatin.moxy_dagger2_kotlin.domain.observables.MainActivityObservable

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityContractView>(), MainActivityContract.Presenter {

    private var isFirstLaunch = true
    private val mainActivityObservable = MainActivityObservable

    private val mainActivityObserver = object : Observer<MainActivityFragment> {

        override fun onSubscribe(d: Disposable) {
            Log.d("myLog", " onSubscribe : " + d.isDisposed)
        }

        override fun onNext(value: MainActivityFragment) {
            when (value) {
                MainActivityFragment.BULGAKOV -> buttonBulgakovSelected()
                MainActivityFragment.BELYAEV -> buttonBelyaevSelected()
            }
            Log.d("myLog", " onNext : value : $value")
        }

        override fun onError(e: Throwable) {
            Log.d("myLog", " onError : " + e.message)
        }

        override fun onComplete() {
            Log.d("myLog", " onComplete")
        }
    }

    override fun activityIsCreating() {
        if (isFirstLaunch) {
            mainActivityObservable.subscribeCurrentFragmentPublishSubject(mainActivityObserver)
        }
        isFirstLaunch = false
    }

    override fun activityIsStarting() {
        buttonBelyaevSelected()
    }

    override fun buttonBelyaevSelected() {
        viewState.createBelyaevFragment()
        viewState.setBelyaevData()
    }

    override fun buttonBulgakovSelected() {
        viewState.createBulgakovFragment()
        viewState.setBulgakovData()
    }

}