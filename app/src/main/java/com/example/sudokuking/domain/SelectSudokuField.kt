package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SudokuField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SelectSudokuField {
    suspend operator fun invoke(_field: SudokuField): Boolean = withContext(Dispatchers.Default) {
        val field = sudokuRepo.getSudokuFieldById(_field.index)
        if (field == null) {
            return@withContext false
        }
        sudokuRepo.deselectSudokuFields()
        field.isSelected = true
        return@withContext true
    }
}