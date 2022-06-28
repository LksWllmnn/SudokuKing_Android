package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteAccountUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        deleteAssociatedResults("" + accountRepo.getActiveAccount()?.id)
        ComputeRegGameResultsUseCase()()
        accountRepo.deleteAccount(accountRepo.getActiveAccount()!!)
        accountRepo.isLoggedIn = false
        accountRepo.getActiveAccount()?.id = ""
        accountRepo.getActiveAccount()?.username = ""
        accountRepo.getActiveAccount()?.password = ""
        sudokuRepo.isASudokuRunning = false
        return@withContext true
    }

    private suspend fun deleteAssociatedResults(id: String) {
        regGameResultRepo.deleteAllWithId(id)
    }
}