package ru.lopatin.mvp_moxy_pattern_kotlin.presentation.fragment.bulgakov

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface BulgakovFragmentContractView : MvpView {
    fun setText(str: String)
    fun showProgressBarFirst(toShow: Boolean)
    fun showProgressBarSecond(toShow: Boolean)
}