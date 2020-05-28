package ru.lopatin.moxy_dagger2_kotlin.domain.use_cases

import ru.lopatin.moxy_dagger2_kotlin.domain.data_classes.Page
import javax.inject.Inject

class ConverterTextToPage @Inject constructor(){
    fun convert(text: String): Page {
        // сложное конвертирование
        return Page(text)
    }
}