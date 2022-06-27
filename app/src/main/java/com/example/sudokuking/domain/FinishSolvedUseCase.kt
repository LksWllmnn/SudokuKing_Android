package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.gameResultRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.GameResult
import com.example.sudokuking.domain.model.RegGameResult
import com.example.sudokuking.domain.model.SolvedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class FinishSolvedUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.getSudoku()[0].isSolved = SolvedState.NotSolved
        sudokuRepo.deselectSudokuFields()

        if(sudokuRepo.isRegisteredGame) {
            regGameResultRepo.addRegGameResult(RegGameResult(UUID.randomUUID().toString(), "" + accountRepo.getActiveAccount()?.id, true, sudokuRepo.runningTime, sudokuRepo.difficulty, 0))
            ComputeRegGameResultsUseCase()()
        } else {
            gameResultRepo.addGameResult(GameResult.create(UUID.randomUUID().toString(),solved = true, time = sudokuRepo.runningTime, difficulty = sudokuRepo.difficulty, sudokuFileLineNumber = 0))
            ComputeGameResultsUseCase()()
        }
        sudokuRepo.isASudokuRunning = false
        sudokuRepo.isRegisteredGame = false

        return@withContext true
    }
}