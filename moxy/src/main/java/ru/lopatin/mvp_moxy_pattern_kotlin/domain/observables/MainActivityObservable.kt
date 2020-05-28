package ru.lopatin.mvp_moxy_pattern_kotlin.domain.observables

import io.reactivex.Observer
import io.reactivex.subjects.BehaviorSubject
import ru.lopatin.mvp_moxy_pattern_kotlin.presentation.activity.MainActivityFragment

object MainActivityObservable {

    private val currentFragmentPublishSubject: BehaviorSubject<MainActivityFragment> = BehaviorSubject.create()

    fun setCurrentFragment(fragment: MainActivityFragment) {
        currentFragmentPublishSubject.onNext(fragment)
    }

    fun subscribeCurrentFragmentPublishSubject(observer: Observer<MainActivityFragment>) {
        currentFragmentPublishSubject.subscribe(observer)
    }
}