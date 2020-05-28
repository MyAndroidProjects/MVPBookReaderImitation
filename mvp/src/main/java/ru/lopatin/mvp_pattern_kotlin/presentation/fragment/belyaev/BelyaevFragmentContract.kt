package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.belyaev

interface BelyaevFragmentContract {
    interface View {
        fun setText(str: String)
        fun showProgressBarFirst(toShow: Boolean)
        fun showProgressBarSecond(toShow: Boolean)
    }

    interface Presenter {
        fun setViewToPresenter(view: View?)
        fun buttonNextPageSelected()
        fun fragmentIsStarting()
        fun buttonBulgakovSelected()
    }

    interface Navigator {
        fun createBulgakovFragment()
        fun setBulgakovDataInMainActivity()
    }

    interface Model {
        suspend fun getTextPartProfessorDoulByIndex(index: Int): String
        suspend fun getProfDoulTextPartsNumber(): Int
    }
}