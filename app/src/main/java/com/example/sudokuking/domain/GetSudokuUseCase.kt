package com.example.sudokuking.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.sudokuking.data.sudokuRepo

class GetSudokuUseCase {
    suspend operator fun invoke() = withContext(Dispatchers.Default) { sudokuRepo.getSudoku() }
}