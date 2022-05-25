package com.example.sudokuking.data

import com.example.sudokuking.domain.model.Sudoku
import com.example.sudokuking.domain.model.SudokuField
import javax.inject.Inject

val sudokuRepo = SudokuRepository()

class SudokuRepository @Inject constructor()
 {
    private val sudoku = listOf(Sudoku.create(
        "test",
        createListOfSudokuFields())
    ).filterNotNull()

     suspend fun getSudoku() = sudoku
}

fun createListOfSudokuFields(): MutableList<MutableList<SudokuField>> {
    val sudoku: MutableList<MutableList<SudokuField>> = mutableListOf()


    for (rows in 1..9) {
        var sudokuRow: MutableList <SudokuField> = mutableListOf()
        for(columns in 1..9) {
            sudokuRow.add(SudokuField.create(null,number = rows * 10 + columns))
        }
        sudoku.add(sudokuRow)
    }
    return sudoku
}