package ru.lopatin.mvp_pattern_kotlin.domain.use_cases

import ru.lopatin.mvp_pattern_kotlin.domain.data_classes.Page

class ConverterPageToString(private val page: Page) {
    fun convert(): String {
        // сложная логика
        return page.text
    }
}