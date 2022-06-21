package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.domain.model.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class RegisterAccountUseCase {
    suspend operator fun invoke(_name: String, _password: String): Boolean = withContext(Dispatchers.Default) {
        try {
        accountRepo.accountIsRegistered = true
        accountRepo.getAllAccounts().map { account ->
            if(account?.username == _name) {
                accountRepo.usernameAlreadyExists = true
                return@withContext false
            }
        }
        accountRepo.addAccount(Account.create(UUID.randomUUID().toString(), _name, _password))
        return@withContext true
        } catch (e: Exception) {
            return@withContext false
        }
    }
}