package ru.lopatin.moxy_dagger2_kotlin

import android.app.Application
import ru.lopatin.moxy_dagger2_kotlin.domain.di.AppComponent
import ru.lopatin.moxy_dagger2_kotlin.domain.di.DaggerAppComponent
import ru.lopatin.moxy_dagger2_kotlin.domain.di.MainModule


class App : Application() {

    companion object {
        val componentInject: AppComponent = buildComponentInject()

        val componentGet: AppComponent = buildComponentGet()

        private fun buildComponentInject(): AppComponent {
            return DaggerAppComponent.builder()
                .mainModule(MainModule())
                .build()

        }

        /**
         * для предоставления get- компонентов не обязательно прописывать модуль в билдере,
         * но и с модулями (как в inject) все будет работать
         */
        private fun buildComponentGet(): AppComponent {
            return DaggerAppComponent.builder().build()

        }
    }
}