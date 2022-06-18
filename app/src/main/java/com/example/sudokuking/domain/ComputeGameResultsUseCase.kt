package com.example.sudokuking.domain

import com.example.sudokuking.data.gameResultRepo
import com.example.sudokuking.data.statisticRepo
import com.example.sudokuking.domain.model.GameResult
import com.example.sudokuking.domain.model.Statistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComputeGameResultsUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        calcAllGameResults()
        return@withContext true
    }

    suspend fun calcAllGameResults() {
        val allGameResults: List<GameResult> = gameResultRepo.getAllGameResults()
        allGameResults.forEach { gameResult ->
            when (gameResult.difficulty) {
                "easy" -> computeGameResultToStatistic(gameResult, getStatWithSpecificDifficulty("easy"))
                "medium" -> computeGameResultToStatistic(gameResult, getStatWithSpecificDifficulty("medium"))
                "hard" -> computeGameResultToStatistic(gameResult, getStatWithSpecificDifficulty("hard"))
            }
        }
    }

    private fun getStatWithSpecificDifficulty(difficulty: String): Statistic {
        var result: Statistic = Statistic.create("", 0,0,0,0, 0, mutableListOf())
        statisticRepo.getAllStatistics().forEach { statistic ->
            if(statistic.title == difficulty)
                result = statistic
            return statistic
        }
        return result
    }

    private fun computeGameResultToStatistic(_gameResult: GameResult, statistic: Statistic) {
        var isNotInYet = true
        statistic.gameResults.forEach { gameResult ->
            if(gameResult.id == _gameResult.id) isNotInYet = false
        }
        if(isNotInYet)statistic.gameResults.add(_gameResult)

        statistic.amount = statistic.gameResults.count()

        var counterResolved = 0
        var timeSum: Long = 0
        statistic.best = statistic.gameResults[0].time
        statistic.gameResults.forEach{gameResult ->
            timeSum += gameResult.time
            if(gameResult.time < statistic.best) statistic.best = gameResult.time
            if(gameResult.solved) counterResolved++
        }
        statistic.average = timeSum/statistic.amount
        statistic.resolved = (counterResolved / statistic.amount) * 100
        statistic.unresolved = 100 - statistic.resolved
    }
}