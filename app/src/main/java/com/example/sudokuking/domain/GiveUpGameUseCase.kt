package com.example.sudokuking.domain

import com.example.sudokuking.data.gameResultRepo
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.GameResult
import com.example.sudokuking.domain.model.SolvedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class GiveUpGameUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.getSudoku()[0].isSolved = SolvedState.NotSolved
        sudokuRepo.deselectSudokuFields()
        sudokuRepo.isASudokuRunning = false
        gameResultRepo.addGameResult(GameResult.create(UUID.randomUUID().toString(),solved = false, time = sudokuRepo.runningTime, difficulty = "easy", sudokuFileLineNumber = 0))
        ComputeGameResultsUseCase()()
        sudokuRepo.attemptToGiveUp = false
        return@withContext true
    }
}