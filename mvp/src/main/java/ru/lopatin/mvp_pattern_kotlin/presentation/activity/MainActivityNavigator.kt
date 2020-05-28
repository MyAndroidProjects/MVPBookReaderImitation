package ru.lopatin.mvp_pattern_kotlin.presentation.activity

import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManager
import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManagerContract

object MainActivityNavigator : MainActivityContract.Navigator {
    private val manager = NavigationManager as NavigationManagerContract.Manager

    override fun createBelyaevFragment() {
        manager.createBelyaevFragment()
    }

    override fun createBulgakovFragment() {
        manager.createBulgakovFragment()
    }
}