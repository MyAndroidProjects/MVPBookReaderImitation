package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.bulgakov

import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManager
import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManagerContract

object BulgakovFragmentNavigator:BulgakovFragmentContract.Navigator {
    private val manager = NavigationManager as NavigationManagerContract.Manager

    override fun createBelyaevFragment() {
        manager.createBelyaevFragment()
    }

    override fun setBelyaevDataInMainActivity() {
        manager.setBelyaevDataInMainActivity()
    }
}