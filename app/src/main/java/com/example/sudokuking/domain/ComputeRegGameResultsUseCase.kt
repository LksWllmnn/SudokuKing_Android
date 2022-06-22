package com.example.sudokuking.domain

import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.regStatisticRepo
import com.example.sudokuking.data.statisticRepo
import com.example.sudokuking.domain.model.RegGameResult
import com.example.sudokuking.domain.model.RegStatistic
import com.example.sudokuking.domain.model.Statistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComputeRegGameResultsUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        calcAllRegGameResults()
        return@withContext true
    }

    private suspend fun calcAllRegGameResults() {
        val allRegGameResults: List<RegGameResult> = regGameResultRepo.getAllRegGameResults()
        allRegGameResults.forEach { regGameResult ->
            when (regGameResult.difficulty) {
                "easy" -> computeRegGameResultToStatistic(regGameResult, getRegStatWithSpecificDifficulty("easy"))
                "medium" -> computeRegGameResultToStatistic(regGameResult, getRegStatWithSpecificDifficulty("medium"))
                "hard" -> computeRegGameResultToStatistic(regGameResult, getRegStatWithSpecificDifficulty("hard"))
            }
        }
    }

    private fun getRegStatWithSpecificDifficulty(difficulty: String): RegStatistic {
        var result: RegStatistic = RegStatistic.create("","", 0,0,0,0, 0, mutableListOf())
        regStatisticRepo.getAllRegStatistics().forEach { regStatistic ->
            if(regStatistic.title == difficulty)
                result = regStatistic
            return regStatistic
        }
        return result
    }

    private fun computeRegGameResultToStatistic(_regGameResult: RegGameResult, regStatistic: RegStatistic) {
        var isNotInYet = true
        regStatistic.regGameResults.forEach { gameResult ->
            if(gameResult.id == _regGameResult.id) isNotInYet = false
        }
        if(isNotInYet)regStatistic.regGameResults.add(_regGameResult)

        regStatistic.amount = regStatistic.regGameResults.count()

        var counterResolved = 0
        var timeSum: Long = 0
        regStatistic.best = regStatistic.regGameResults[0].time
        regStatistic.regGameResults.forEach{gameResult ->
            if(gameResult.solved) timeSum += gameResult.time
            if(gameResult.time < regStatistic.best && gameResult.solved) regStatistic.best = gameResult.time
            if(gameResult.solved) counterResolved++
        }
        regStatistic.average = timeSum/counterResolved
        regStatistic.resolved = (counterResolved * 100/regStatistic.amount)
        regStatistic.unresolved = 100 - regStatistic.resolved
    }
}