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

            for(i in 0..9) {
                for(j in (0+i)..(9+i)) {
                    var field = sudokuRepo.getSudokuFieldById(i*10+j-i)
                    if (field != null) {
                        if (result[i*10+j].toString() == "0") {
                            field.number = ""
                            field.isFixed = false
                        }
                        else {
                            field.number = result[i*10+j].toString()
                            field.isFixed = true
                        }
                    }
                }
            }

            for(i in 10..18) {
                for(j in 0..8) {
                    var field = sudokuRepo.getFinishedSudokuFieldById((i-10)*10+j)
                    if (field != null) {
                        field.number = result[i*10+j].toString()
                    }
                }
            }
            return@withContext true
        }catch (e: Exception) {
            return@withContext false
        }
    }
}