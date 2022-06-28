package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SudokuField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SelectSudokuField {
    suspend operator fun invoke(fieldP: SudokuField): Boolean = withContext(Dispatchers.Default) {
        val field = sudokuRepo.getSudokuFieldById(fieldP.index)
        if (field == null) {
            return@withContext false
        }
        if (field.isFixed) {
            return@withContext false
        }
        sudokuRepo.deselectSudokuFields()
        field.isSelected = true
        return@withContext true
    }
}