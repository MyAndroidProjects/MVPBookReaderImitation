package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.belyaev

interface BelyaevFragmentContract {

    interface Presenter {
        fun buttonNextPageSelected()
        fun fragmentIsStarting()
        fun buttonBulgakovSelected()
    }

    interface Model {
        suspend fun getTextPartProfessorDoulByIndex(index: Int): String
        suspend fun getProfDoulTextPartsNumber(): Int
    }
}