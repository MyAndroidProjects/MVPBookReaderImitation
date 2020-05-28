package ru.lopatin.mvp_pattern_kotlin.presentation.activity

interface MainActivityContract {
    interface View {
        fun setBulgakovData()
        fun setBelyaevData()
    }

    interface Presenter {
        fun setViewToPresenter(view: View?)
        fun activityIsStarting()
        fun buttonBelyaevSelected()
        fun buttonBulgakovSelected()
    }

    interface Navigator {
        fun createBelyaevFragment()
        fun createBulgakovFragment()
    }
}