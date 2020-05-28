package ru.lopatin.mvp_pattern_kotlin.data.repository_gateways

import kotlinx.coroutines.*
import ru.lopatin.mvp_pattern_kotlin.data.storage.StorageImitation
import ru.lopatin.mvp_pattern_kotlin.presentation.fragment.belyaev.BelyaevFragmentContract
import ru.lopatin.mvp_pattern_kotlin.presentation.fragment.bulgakov.BulgakovFragmentContract

class Repository : BulgakovFragmentContract.Model, BelyaevFragmentContract.Model {

    override suspend fun getMasterAndMargaritaTextPartsNumber(): Int {
        // запрос к базе данных
        val storageImitation = StorageImitation()
        delay(1000)
        return storageImitation.masterAndMargarita.size
    }

    override suspend fun getTextPartMasterAndMargaritaByIndex(index: Int): String {
        // запрос к базе данных
        val storageImitation = StorageImitation()
        delay(500)
        return storageImitation.masterAndMargarita[index]

    }

    override suspend fun getProfDoulTextPartsNumber(): Int {
        val storageImitation2 = StorageImitation()
        delay(1000)
        return storageImitation2.professorDoul.size
    }

    override suspend fun getTextPartProfessorDoulByIndex(index: Int): String {
        val storageImitation = StorageImitation()
        delay(500)
        return storageImitation.professorDoul[index]
    }
}