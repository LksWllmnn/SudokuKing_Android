package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SolvedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContinueAfterWrongUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.getSudoku()[0].isSolved = SolvedState.NotSolved
        return@withContext true
    }
}