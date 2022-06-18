package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadSudokuFromFileUseCase {
    suspend operator fun invoke(stage: Int): Boolean = withContext(Dispatchers.Default) {
        try {
            val allSudoku = sudokuRepo.allSudokuString

            var counter = 0
            var counter2 = 83

            if(stage == 0) {
                counter = 0
                counter2 = 83
            } else if(stage == 1) {
                counter = 166
                counter2 = 249
            } else if(stage == 2) {
                counter = 332
                counter2 = 415
            }

            for(i in 0..8) {
                for(j in 0..8) {
                    val field = sudokuRepo.getSudokuFieldById(i*10+j)
                    if(field != null) {
                        val loadedNum = allSudoku[counter].toString()
                        if(loadedNum == "0") {
                            field.isFixed = false
                            field.number = ""
                        } else {
                            field.isFixed = true
                            field.number = loadedNum
                        }
                        counter++
                    }
                }
            }

            for(i in 0..8) {
                for(j in 0..8) {
                    val field = sudokuRepo.getFinishedSudokuFieldById(i*10+j)
                    if (field != null) {
                        field.number = allSudoku[counter2].toString()
                        counter2++
                    }
                }
            }
            sudokuRepo.isASudokuRunning = true
            sudokuRepo.startTime = System.currentTimeMillis()
            return@withContext true
        }catch (e: Exception) {
            return@withContext false
        }
    }
}