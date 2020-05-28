package ru.lopatin.mvp_moxy_pattern_kotlin.domain.use_cases

import android.util.Log
import kotlinx.coroutines.*
import ru.lopatin.mvp_moxy_pattern_kotlin.domain.data_classes.Page

class ConverterTextToStringWithContract(private val textToConvert: String, stringReceiver: IConverterContract) {
    init {
        GlobalScope.launch(Dispatchers.Default) {
            // при ошибке получения данный выбрасывает ошибку
            try {
                val converterTextToPage = ConverterTextToPage(textToConvert)
                val page: Page = converterTextToPage.convert()
                val converterPageToString = ConverterPageToString(page)
                // долгие вычисления
                delay(500)
                // меняем контекст на контекст с главным потоком
                withContext(Dispatchers.Main) {
                    stringReceiver.getConvertedString(converterPageToString.convert())
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