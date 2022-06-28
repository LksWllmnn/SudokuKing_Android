package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.domain.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateAccountUseCase {
    suspend operator fun invoke(account: Account): Boolean = withContext(Dispatchers.Default) {
        try {
            accountRepo.updateAccount(account)
            return@withContext true
        } catch (e:Exception) {
            return@withContext false
        }
    }
}