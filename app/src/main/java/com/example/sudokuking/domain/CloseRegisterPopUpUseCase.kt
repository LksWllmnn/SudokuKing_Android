package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CloseRegisterPopUpUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        accountRepo.accountIsRegistered = false
        accountRepo.usernameAlreadyExists = false
        return@withContext true
    }
}