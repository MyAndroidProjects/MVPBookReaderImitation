package ru.lopatin.mvp_pattern_kotlin.presentation.navigation

import ru.lopatin.mvp_pattern_kotlin.presentation.activity.MainActivityPresenter

object NavigationManager : NavigationManagerContract.Manager, NavigationManagerContract.SetActivities {

    private var mainActivity: NavigationManagerContract.MainActivity? = null

    override fun setMainActivityToNavigationManager(mainActivity: NavigationManagerContract.MainActivity?) {
        this.mainActivity = mainActivity
    }

    override fun createBelyaevFragment() {
        mainActivity?.createBelyaevFragment()
    }

    override fun createBulgakovFragment() {
        mainActivity?.createBulgakovFragment()
    }

    override fun setBelyaevDataInMainActivity() {
        val mainActivityPresenter: NavigationManagerContract.MainActivityPresenter = MainActivityPresenter
        mainActivityPresenter.setBelyaevData()
    }

    override fun setBulgakovDataInMainActivity() {
        val mainActivityPresenter: NavigationManagerContract.MainActivityPresenter = MainActivityPresenter
        mainActivityPresenter.setBulgakovData()
    }
}