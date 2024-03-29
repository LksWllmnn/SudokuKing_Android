package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateGameTimeUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        sudokuRepo.runningTime = (System.currentTimeMillis() - sudokuRepo.startTime)/1000
        if (((sudokuRepo.runningTime)/60) < 10) {
            if (((sudokuRepo.runningTime)%60) < 10) {
                sudokuRepo.runningTimeOut = "0" +((sudokuRepo.runningTime)/60) + ":0" + ((sudokuRepo.runningTime)%60)
            } else {
                sudokuRepo.runningTimeOut = "0" +((sudokuRepo.runningTime)/60) + ":" + ((sudokuRepo.runningTime)%60)
            }
        } else if (((sudokuRepo.runningTime)%60) < 10) {
            sudokuRepo.runningTimeOut = "" + ((sudokuRepo.runningTime)/60) + ":0" + ((sudokuRepo.runningTime)%60)
        } else {
            sudokuRepo.runningTimeOut = "" + ((sudokuRepo.runningTime)/60) + ":" + ((sudokuRepo.runningTime)%60)
        }

        return@withContext true
    }
}