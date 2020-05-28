package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.activity


/**
 *  Moxy версии 1.7.0 ( также и 1.5.5) не поддерживает вложенные interface
 *  (версия 1.4.6 поддерживала)
 *  если в presenter'е указать MvpPresenter<MainActivityContract.View>()
 *  то будет ошибка  error: cannot find symbol class MainActivityContract$View$$State
 *  поэтому View interface вынесен отдельно
 */

interface MainActivityContract {
/*    @StateStrategyType(value = OneExecutionStateStrategy::class)
    interface View : MvpView {
        fun setBulgakovData()
        fun setBelyaevData()
    }*/

    interface Presenter {
        fun activityIsCreating()
        fun activityIsStarting()
        fun buttonBelyaevSelected()
        fun buttonBulgakovSelected()
    }
}