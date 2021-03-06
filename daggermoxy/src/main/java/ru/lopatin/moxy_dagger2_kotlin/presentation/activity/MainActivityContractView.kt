package ru.lopatin.moxy_dagger2_kotlin.presentation.activity

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainActivityContractView: MvpView {
    fun setBulgakovData()
    fun setBelyaevData()
    fun createBelyaevFragment()
    fun createBulgakovFragment()
}