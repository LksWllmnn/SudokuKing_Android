package com.example.sudokuking.domain

import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SolvedState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckSudokuUseCase {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.Default) {
        var wrongIndexed: MutableList<Int> = mutableListOf()

        for (i in 0..9) {
            for (j in (0+i)..(9+i)) {
                if(sudokuRepo.getSudokuFieldById(i*10+j-i)?.number != sudokuRepo.getFinishedSudokuFieldById(i*10+j-i)?.number) {
                    //sudokuRepo.getSudoku()[0].isSolved = SolvedState.Wrong
                    wrongIndexed.add(i*10+j-i)
                }
            }
        }
        sudokuRepo.getSudoku()[0].wrongNumbers = wrongIndexed

        if(wrongIndexed.count() > 0) {
            sudokuRepo.getSudoku()[0].isSolved = SolvedState.Wrong
            return@withContext false
        }
        sudokuRepo.getSudoku()[0].isSolved = SolvedState.Correct
        return@withContext true
    }
}