package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.regStatisticRepo
import com.example.sudokuking.domain.model.RegGameResult
import com.example.sudokuking.domain.model.RegStatistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComputeRegGameResultsUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        calcAllRegGameResults()
        return@withContext true
    }

    private suspend fun calcAllRegGameResults() {
        val allRegGameResults: List<RegGameResult?> = regGameResultRepo.getAllRegGameResultsByAccId(accountRepo.getActiveAccount()?.id)
        allRegGameResults.forEach { regGameResult ->
            if(regGameResult != null) computeRegGameResultToStatistic(regGameResult, regStatisticRepo.getAllRegStatistics())
        }
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

    private fun computeLineRank() {

    }
}