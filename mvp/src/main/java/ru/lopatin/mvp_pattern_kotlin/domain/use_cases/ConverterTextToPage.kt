package ru.lopatin.mvp_pattern_kotlin.domain.use_cases

import ru.lopatin.mvp_pattern_kotlin.domain.data_classes.Page

class ConverterTextToPage(private val text: String) {
    fun convert(): Page {
        // сложное конвертирование
        return Page(text)
    }
}