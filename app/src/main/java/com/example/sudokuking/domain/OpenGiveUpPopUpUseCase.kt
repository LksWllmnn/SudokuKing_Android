package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OpenGiveUpPopUpUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.attemptToGiveUp = true
        return@withContext true
    }
}