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

    private val allAccounts = listOf(
        Account.create(
            id = "61ae7e7c-7d78-4db5-aab6-0408fac95d40",
            username = "test",
            password = "123456"
        )
    ).filterNotNull()

    suspend fun getAllAccounts(): List<Account?> {
        return dao.getAll().map { account ->
            accountFromDb(account)
        }
    }

    fun getActiveAccount() = activeAccount

    fun loggOutActiveAccount() {
        activeAccount = null
    }

    fun setActiveAccount(_account: Account) {
        activeAccount = _account
    }

    fun getAccountById(id: String): Account? = allAccounts.firstOrNull {
        it.id == id
    }

    suspend fun getAccountByName(name: String): Account? = getAllAccounts().firstOrNull{
            it?.username == name
    }

    suspend fun addAccount(account: Account) {
        dao.insert(
            accountToDb(account)
        )
    }

    suspend fun deleteAccount(_account: Account) {
        dao.delete(
            accountToDb(_account)
        )
    }
}