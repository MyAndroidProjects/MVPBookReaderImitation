package ru.lopatin.moxy_dagger2_kotlin.presentation.fragment.belyaev

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