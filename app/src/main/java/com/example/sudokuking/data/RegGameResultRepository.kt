package com.example.sudokuking.data

import com.example.sudokuking.App
import com.example.sudokuking.data.database.RegGameResultDao
import com.example.sudokuking.data.database.regGameResultFromDb
import com.example.sudokuking.data.database.regGameResultToDb
import com.example.sudokuking.domain.model.RegGameResult
import javax.inject.Inject

val regGameResultRepo = RegGameResultRepository(App.database.regGameResultDao())

class RegGameResultRepository @Inject constructor(
    private val dao: RegGameResultDao
) {
    private suspend fun getAllRegGameResults(): List<RegGameResult> = dao.getAll().map { regGameResultFromDb(it) }

    suspend fun addRegGameResult(gameResult: RegGameResult) {
        dao.insert(
            regGameResultToDb(gameResult)
        )
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    suspend fun getAllRegGameResultsByAccId(_accId: String?): List<RegGameResult?> {
        val result: MutableList<RegGameResult?> = mutableListOf()

        getAllRegGameResults().map { regGameResult ->
            if(regGameResult.accId == _accId) result.add(regGameResult)
        }
        return result
    }

    suspend fun deleteAllWithId(_id: String) {
        dao.deleteWithId(_id)
    }
}