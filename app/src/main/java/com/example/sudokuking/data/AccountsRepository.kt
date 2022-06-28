package com.example.sudokuking.data

import com.example.sudokuking.App
import com.example.sudokuking.data.database.*
import com.example.sudokuking.domain.model.Account
import javax.inject.Inject

val accountRepo = AccountsRepository(App.database.accountDao())

class AccountsRepository @Inject constructor(
    private val dao: AccountDao
    ) {

    var isLoggedIn = false
    var inputsWereChecked = false

    var accountIsRegistered = false
    var usernameAlreadyExists: Boolean = false

    private var activeAccount: Account? = null

    suspend fun getAllAccounts(): List<Account?> {
        return dao.getAll().map { account ->
            accountFromDb(account)
        }
    }

    fun getActiveAccount() = activeAccount

    fun loggOutActiveAccount() {
        activeAccount = null
    }

    fun setActiveAccount(account: Account) {
        activeAccount = account
    }

    suspend fun getAccountByName(name: String): Account? = getAllAccounts().firstOrNull{
            it?.username == name
    }

    suspend fun addAccount(account: Account) {
        dao.insert(
            accountToDb(account)
        )
    }

    suspend fun deleteAccount(account: Account) {
        dao.delete(
            accountToDb(account)
        )
    }

    suspend fun updateAccount(account: Account) {
        dao.update(accountToDb(account))
    }
}