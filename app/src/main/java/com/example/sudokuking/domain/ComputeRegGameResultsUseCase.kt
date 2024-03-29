package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.regStatisticRepo
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.RankTitle
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

    private fun computeRegGameResultToStatistic(regGameResultP: RegGameResult, regStatistic: RegStatistic) {
        var isNotInYet = true
        regStatistic.regGameResults.forEach { gameResult ->
            if(gameResult.id == regGameResultP.id) isNotInYet = false
        }
        if(isNotInYet)regStatistic.regGameResults.add(regGameResultP)

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

        val activeAccount = accountRepo.getActiveAccount()
        val amountSudoku = sudokuRepo.allSudokuString.length/166
        if(activeAccount != null) {
            computeNewRankTitle(activeAccount.lineRank, amountSudoku)
            computeRankProgress(activeAccount.lineRank, amountSudoku)
        }
    }

    private fun computeNewRankTitle(line: Int, amountSudoku: Int) {
        when (line / (amountSudoku / 4) ) {
            0 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Bronze
            1 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Silver
            2 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Gold
            3 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Diamond
        }
        if(line == amountSudoku -1) {
            accountRepo.getActiveAccount()?.rankTitle = RankTitle.Finished
        }
    }

    private fun computeRankProgress(newLine: Int, amountSudoku: Int):Int {
        return (((newLine%(amountSudoku/4)).toFloat()/(amountSudoku/4).toFloat())*100).toInt()
    }
}