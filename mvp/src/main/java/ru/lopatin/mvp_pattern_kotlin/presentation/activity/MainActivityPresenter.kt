package ru.lopatin.mvp_pattern_kotlin.presentation.activity

import ru.lopatin.mvp_pattern_kotlin.presentation.navigation.NavigationManagerContract

object MainActivityPresenter : MainActivityContract.Presenter, NavigationManagerContract.MainActivityPresenter {


    private var view: MainActivityContract.View? = null
    private val navigator = MainActivityNavigator as MainActivityContract.Navigator


    override fun setViewToPresenter(view: MainActivityContract.View?) {
        this.view = view
    }

    override fun activityIsStarting() {
        buttonBelyaevSelected()
    }

    override fun buttonBelyaevSelected() {
        navigator.createBelyaevFragment()
        view?.setBelyaevData()
    }

    override fun buttonBulgakovSelected() {
        navigator.createBulgakovFragment()
        view?.setBulgakovData()
    }

    override fun setBelyaevData() {
        view?.setBelyaevData()
    }

    override fun setBulgakovData() {
        view?.setBulgakovData()
    }
}