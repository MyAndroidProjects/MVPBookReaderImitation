package ru.lopatin.mvp_pattern_kotlin.presentation.fragment.belyaev

import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManager
import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManagerContract

object BelyaevFragmentNavigator: BelyaevFragmentContract.Navigator{

    private val manager = NavigationManager as NavigationManagerContract.Manager
    override fun createBulgakovFragment() {
        manager.createBulgakovFragment()
    }

    override fun setBulgakovDataInMainActivity() {
        manager.setBulgakovDataInMainActivity()
    }

}