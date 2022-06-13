package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteNumberUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        val selectedField = sudokuRepo.getSelectedField()
        if (selectedField == null) {
            return@withContext false
        }
        selectedField.number = ""
        return@withContext true
    }
}