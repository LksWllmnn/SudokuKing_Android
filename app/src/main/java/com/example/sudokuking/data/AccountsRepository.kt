package com.example.sudokuking.data

import com.example.sudokuking.domain.model.Account
import com.example.sudokuking.domain.model.AccountId

val accountRepo = AccountsRepository()

class AccountsRepository {

    private val allAccounts = listOf(
        Account.create(
            id = AccountId("61ae7e7c-7d78-4db5-aab6-0408fac95d40"),
            username = "test",
            password = "123456"
        )
    ).filterNotNull()

    suspend fun getAllAccounts() = allAccounts

    suspend fun getAccountById(id: AccountId): Account? = allAccounts.firstOrNull {
        it.id == id
    }
}