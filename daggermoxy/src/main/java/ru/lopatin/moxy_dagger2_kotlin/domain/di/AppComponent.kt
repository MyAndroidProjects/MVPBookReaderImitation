package ru.lopatin.moxy_dagger2_kotlin.domain.di

import dagger.Component
import ru.lopatin.moxy_dagger2_kotlin.domain.use_cases.ConverterTextToPage
import ru.lopatin.moxy_dagger2_kotlin.domain.use_cases.ConverterTextToStringWithContract
import ru.lopatin.moxy_dagger2_kotlin.presentation.activity.MainActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [MainModule::class]) // массив модулей, к которым будет доступ
interface AppComponent {
    /**
     * методы, указывающие на то, в каком классе будет происходить инжекция, так называемые inject методы
     */
    fun inject(activity: MainActivity)
    fun inject(converterTextToStringWithContract: ConverterTextToStringWithContract)

    /**
     * другой способ
     * методы, указывающие на то, какой класс предоставить get-методы
     */
       fun getConverterTextToPage() : ConverterTextToPage
}