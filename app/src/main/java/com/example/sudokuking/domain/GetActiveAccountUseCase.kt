package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetActiveAccountUseCase {
    suspend operator fun invoke() = withContext(Dispatchers.Default) { accountRepo.getActiveAccount() }
}