package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.bulgakov


interface BulgakovFragmentContract {
    interface View {
        fun setText(str: String)
        fun showProgressBarFirst(toShow: Boolean)
        fun showProgressBarSecond(toShow: Boolean)
    }

    interface Presenter {
        fun setViewToPresenter(view: View?)
        fun buttonNextPageSelected()
        fun fragmentIsStarting()
        fun buttonBelyaevSelected()
    }

    interface Navigator {
        fun createBelyaevFragment()
        fun setBelyaevDataInMainActivity()
    }

    interface Model {
        suspend fun getMasterAndMargaritaTextPartsNumber(): Int
        suspend fun getTextPartMasterAndMargaritaByIndex(index: Int): String
    }
}