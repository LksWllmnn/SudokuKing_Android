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
    suspend fun getAllRegGameResults(): List<RegGameResult> = dao.getAll().map { regGameResultFromDb(it)}

    suspend fun addRegGameResult(gameResult: RegGameResult) {
        dao.insert(
            regGameResultToDb(gameResult)
        )
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}