package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SolvedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FinishSolvedUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.getSudoku()[0].isSolved = SolvedState.NotSolved
        sudokuRepo.deselectSudokuFields()
        sudokuRepo.isASudokuRunning = false
        return@withContext true
    }
}