package ru.lopatin.moxy_dagger2_kotlin.domain.di

import dagger.Module
import dagger.Provides
import ru.lopatin.moxy_dagger2_kotlin.domain.use_cases.ConverterPageToString


@Module
class MainModule {
  @Provides
    fun providesConverterPageToString(): ConverterPageToString {
        return ConverterPageToString()
    }
}