package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.bulgakov


interface BulgakovFragmentContract {
    interface Presenter {
        fun buttonNextPageSelected()
        fun fragmentIsStarting()
        fun buttonBelyaevSelected()
    }

    interface Model {
        suspend fun getMasterAndMargaritaTextPartsNumber(): Int
        suspend fun getTextPartMasterAndMargaritaByIndex(index: Int): String
    }
}