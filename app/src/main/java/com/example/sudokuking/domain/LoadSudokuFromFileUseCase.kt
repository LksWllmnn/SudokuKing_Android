package com.example.sudokuking.domain

import android.content.Context
import com.example.sudokuking.R
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.feature.sudoku.SudokuViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadSudokuFromFileUseCase {
    suspend operator fun invoke(context: Context): Boolean = withContext(Dispatchers.Default) {
        try {
            var result = context.resources.openRawResource(R.raw.sudoku).bufferedReader().use{it.readText()}

            result

            var counter = 0
            for(i in 0..8) {
                for(j in 0..8) {
                    var field = sudokuRepo.getSudokuFieldById(i*10+j)
                    if(field != null) {
                        field.number = result[counter].toString()
                        counter++
                    }
                }
            }

            var counter2 = 83
            for(i in 0..8) {
                for(j in 0..8) {
                    var field = sudokuRepo.getFinishedSudokuFieldById(i*10+j)
                    if (field != null) {
                        field.number = result[counter2].toString()
                        counter2++
                    }
                }
            }
            return@withContext true
        }catch (e: Exception) {
            return@withContext false
        }
    }
}