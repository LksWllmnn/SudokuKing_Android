package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.domain.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoggOutUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        accountRepo.isLoggedIn = false
        accountRepo.loggOutActiveAccount()

        return@withContext true
    }
}