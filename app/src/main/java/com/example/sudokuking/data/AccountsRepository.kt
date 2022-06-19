package com.example.sudokuking.data

import com.example.sudokuking.domain.model.Account

val accountRepo = AccountsRepository()

class AccountsRepository {
    var isLoggedIn = false
    var inputsWereChecked = false

    private var activeAccount: Account? = null

    private val allAccounts = listOf(
        Account.create(
            id = "61ae7e7c-7d78-4db5-aab6-0408fac95d40",
            username = "test",
            password = "123456"
        )
    ).filterNotNull()

    suspend fun getAllAccounts() = allAccounts

    fun getActiveAccount() = activeAccount

    suspend fun getAccountById(id: String): Account? = allAccounts.firstOrNull {
        it.id == id
    }

    fun getAccountByName(name: String): Account? = allAccounts.firstOrNull{
            it.username == name
    }
}