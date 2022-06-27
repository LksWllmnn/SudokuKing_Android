package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadSudokuFromFileUseCase {
    suspend operator fun invoke(stage: Int): Boolean = withContext(Dispatchers.Default) {
        try {
            val allSudoku = sudokuRepo.allSudokuString

            var counter = getLines(stage)
            var counter2 = counter + 83

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

    private suspend fun getLines(stage: Int): Int {
        return selectRandomFactor(stage) * 166
    }

    private suspend fun selectRandomFactor(stage: Int): Int {
        val amountSudoku = sudokuRepo.allSudokuString.length/166
        when(stage) {
            0 -> sudokuRepo.difficulty = "easy"
            1 -> sudokuRepo.difficulty = "medium"
            2 -> sudokuRepo.difficulty = "hard"
        }
        if(stage == 4) {
            sudokuRepo.isRegisteredGame = true
            val lastLine = accountRepo.getActiveAccount()?.lineRank
            val regSteps = amountSudoku / 4
            var newLine = 0
            if(lastLine!=null) {
                var wasLastGameWin = true
                val lgFun = wasLastGameWin()
                if(lgFun!= null) wasLastGameWin = lgFun

                if(wasLastGameWin) newLine =  lastLine + randomNum(regSteps)
                else if(wasLastGameWin() == false && lastLine == 0) newLine =  lastLine
                else newLine =  lastLine - randomNum(regSteps)

                var account = accountRepo.getActiveAccount()
                account?.lineRank = newLine
                if(account!=null) UpdateAccountUseCase()(account)
            }
            return newLine
        }
        val rangeDifficultySteps = amountSudoku / 3
        return stage * rangeDifficultySteps + (randomNum(rangeDifficultySteps))
    }

    private fun randomNum(range: Int): Int {
        return (0..range).random()
    }

    private suspend fun wasLastGameWin(): Boolean? {
        val regGames = regGameResultRepo.getAllRegGameResultsByAccId(accountRepo.getActiveAccount()?.id)
        return regGames.last()?.solved
    }
}