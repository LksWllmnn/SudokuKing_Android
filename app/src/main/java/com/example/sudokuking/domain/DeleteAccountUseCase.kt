package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteAccountUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        accountRepo.deleteAccount(accountRepo.getActiveAccount()!!)
        accountRepo.isLoggedIn = false
        accountRepo.getActiveAccount()?.id = ""
        accountRepo.getActiveAccount()?.username = ""
        accountRepo.getActiveAccount()?.password = ""
        return@withContext true
    }
}