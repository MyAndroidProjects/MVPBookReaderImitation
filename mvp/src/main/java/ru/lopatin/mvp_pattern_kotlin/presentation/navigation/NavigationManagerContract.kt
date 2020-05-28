package ru.lopatin.mvp_pattern_kotlin.presentation.navigation

interface NavigationManagerContract {
    interface SetActivities {
        fun setMainActivityToNavigationManager(mainActivity: MainActivity?)
    }

    interface Manager {
        fun createBelyaevFragment()
        fun createBulgakovFragment()
        fun setBelyaevDataInMainActivity()
        fun setBulgakovDataInMainActivity()
    }

    interface MainActivity {
        fun createBelyaevFragment()
        fun createBulgakovFragment()
    }

    interface MainActivityPresenter {
        fun setBelyaevData()
        fun setBulgakovData()
    }
}