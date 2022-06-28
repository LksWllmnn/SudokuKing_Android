package com.example.sudokuking.domain

import com.example.sudokuking.data.accountRepo
import com.example.sudokuking.data.regGameResultRepo
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.RankTitle
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
            4 -> return computeRegistered(amountSudoku)
        }
        val rangeDifficultySteps = amountSudoku / 3
        return stage * rangeDifficultySteps + (randomNum(rangeDifficultySteps))
    }

    private fun randomNum(range: Int): Int {
        return (1..range).random()
    }

    private suspend fun wasLastGameWin(): Boolean? {
        val regGames = regGameResultRepo.getAllRegGameResultsByAccId(accountRepo.getActiveAccount()?.id)
        return regGames.last()?.solved
    }

    private suspend fun computeRegistered(_amountSudoku: Int):Int {
        sudokuRepo.isRegisteredGame = true
        val lastLine = accountRepo.getActiveAccount()?.lineRank
        val regSteps = _amountSudoku / 4
        var newLine = 0
        if(lastLine!=null) {
            try {
                var wasLastGameWin = true
                val lgFun = wasLastGameWin()
                if(lgFun!= null) wasLastGameWin = lgFun

                if(wasLastGameWin) {
                    newLine =  lastLine + randomNum(regSteps)

                }
                else if(lgFun == false && lastLine <= 0) newLine =  lastLine
                else newLine =  lastLine - randomNum(regSteps)
            } catch (e:Exception) {
                newLine = 0
            }
            computeNewRankTitle(newLine, _amountSudoku)

            var account = accountRepo.getActiveAccount()
            account?.lineRank = newLine
            account?.progress = computeRankProgress(newLine, _amountSudoku)
            if(account!=null) UpdateAccountUseCase()(account)
        }
        return newLine
    }

    private fun computeNewRankTitle(_newLine: Int, _amountSudoku: Int) {
        when (_newLine / (_amountSudoku / 4) ) {
            0 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Bronze
            1 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Silver
            2 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Gold
            3 -> accountRepo.getActiveAccount()?.rankTitle = RankTitle.Diamond
        }
        if(_newLine == _amountSudoku -1) {
            accountRepo.getActiveAccount()?.rankTitle = RankTitle.Finished
        }
    }

    private fun computeRankProgress(_newLine: Int, _amountSudoku: Int):Int {
        return (((_newLine%(_amountSudoku/4)).toFloat()/(_amountSudoku/4).toFloat())*100).toInt()
    }
}