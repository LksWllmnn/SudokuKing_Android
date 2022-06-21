package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.domain.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckAccountInputsUseCase {
    suspend operator fun invoke(name: String, password: String): Boolean = withContext(Dispatchers.Default) {
        accountRepo.inputsWereChecked = true
        val repoResult = accountRepo.getAccountByName(name)
        if(repoResult != null) {
            val originAccount: Account = repoResult
            if (originAccount.password == password) {
                accountRepo.setActiveAccount(originAccount)
                accountRepo.isLoggedIn = true
            } else {
                return@withContext false
            }
            return@withContext true
        } else {
            return@withContext false
        }
    }
}