package ru.lopatin.moxy_dagger2_kotlin.domain.use_cases

import ru.lopatin.moxy_dagger2_kotlin.domain.data_classes.Page
import javax.inject.Inject


class ConverterPageToString  @Inject constructor() {
    fun convert(page: Page): String {
        var str1 = "str1"

        // сложная логика
        return page.text
    }


}