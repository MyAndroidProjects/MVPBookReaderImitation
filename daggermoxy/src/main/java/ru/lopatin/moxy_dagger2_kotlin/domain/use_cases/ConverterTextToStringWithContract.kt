package ru.lopatin.moxy_dagger2_kotlin.domain.use_cases

import android.util.Log
import kotlinx.coroutines.*
import ru.lopatin.moxy_dagger2_kotlin.App
import ru.lopatin.moxy_dagger2_kotlin.domain.data_classes.Page
import javax.inject.Inject

class ConverterTextToStringWithContract(private val textToConvert: String, stringReceiver: IConverterContract) {

   // private val converterTextToPageFromComponentGet: ConverterTextToPage

    @Inject
    lateinit var converterTextToPageFromComponentInject: ConverterTextToPage

    /**
     * FromComponentGet
     */
/*    init {
        converterTextToPageFromComponentGet = App.componentGet.getConverterTextToPage()
        GlobalScope.launch(Dispatchers.Default) {
            // при ошибке получения данный выбрасывает ошибку
            try {
                val page: Page = converterTextToPageFromComponentGet.convert(textToConvert)
                val converterPageToString = ConverterPageToString()
                // долгие вычисления
                delay(500)
                // меняем контекст на контекст с главным потоком
                withContext(Dispatchers.Main) {
                    stringReceiver.getConvertedString(converterPageToString.convert(page))
                }
            } catch (ex: Exception) {
                Log.d("myLog", " Exception $ex ")
            }
        }
    }*/

    /**
     * FromComponentInject
     */
    init {
        App.componentInject.inject(this)
        GlobalScope.launch(Dispatchers.Default) {
            // при ошибке получения данный выбрасывает ошибку
            try {
                val page: Page = converterTextToPageFromComponentInject.convert(textToConvert)
                val converterPageToString = ConverterPageToString()
                // долгие вычисления
                delay(500)
                // меняем контекст на контекст с главным потоком
                withContext(Dispatchers.Main) {
                    stringReceiver.getConvertedString(converterPageToString.convert(page))
                }
            } catch (ex: Exception) {
                Log.d("myLog", " Exception $ex ")
            }
        }
    }

    interface IConverterContract {
        fun getConvertedString(textString: String)
    }
}