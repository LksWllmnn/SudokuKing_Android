package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SetNewNumberUseCase {
    suspend operator fun invoke(_number: Int): Boolean = withContext(Dispatchers.Default) {
        val selectedField = sudokuRepo.getSelectedField()
        if (selectedField == null) {
            return@withContext false
        }
        selectedField.number = _number
        return@withContext true
    }
}