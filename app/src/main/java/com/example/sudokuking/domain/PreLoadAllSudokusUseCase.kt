package com.example.sudokuking.domain

import android.content.Context
import com.example.sudokuking.R
import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PreLoadAllSudokusUseCase {
    suspend operator fun invoke(context: Context): Boolean = withContext(Dispatchers.Default) {
        try {
            sudokuRepo.allSudokuString = context.resources.openRawResource(R.raw.sudoku).bufferedReader().use{it.readText()}
            return@withContext true
        } catch (e: Exception) {
            return@withContext false
        }
    }
}