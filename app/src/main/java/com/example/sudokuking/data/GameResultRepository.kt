package com.example.sudokuking.data

import com.example.sudokuking.App
import com.example.sudokuking.data.database.GameResultDao
import com.example.sudokuking.domain.model.GameResult
import com.example.sudokuking.data.database.gameResultFromDb
import com.example.sudokuking.data.database.gameResultToDb
import javax.inject.Inject

val gameResultRepo = GameResultRepository(App.database.gameResultsDao())

class GameResultRepository @Inject constructor(
    private val dao: GameResultDao
)
{
    suspend fun getAllGameResults(): List<GameResult> = dao.getAll().map{ gameResultFromDb(it) }

    suspend fun addGameResult(gameResult: GameResult) {
        dao.insert(
            gameResultToDb(gameResult)
        )
    }
}