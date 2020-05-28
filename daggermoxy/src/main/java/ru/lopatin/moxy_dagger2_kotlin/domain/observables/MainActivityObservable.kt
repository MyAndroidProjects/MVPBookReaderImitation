package ru.lopatin.moxy_dagger2_kotlin.domain.observables

import io.reactivex.Observer
import io.reactivex.subjects.BehaviorSubject
import ru.lopatin.moxy_dagger2_kotlin.presentation.activity.MainActivityFragment

/**
 * Через этот объект передаются команды на создание фрагмента из другого фрагмента в activity
 */
object MainActivityObservable {

    private val currentFragmentPublishSubject: BehaviorSubject<MainActivityFragment> = BehaviorSubject.create()

    fun setCurrentFragment(fragment: MainActivityFragment) {
        currentFragmentPublishSubject.onNext(fragment)
    }

    fun subscribeCurrentFragmentPublishSubject(observer: Observer<MainActivityFragment>) {
        currentFragmentPublishSubject.subscribe(observer)
    }
}