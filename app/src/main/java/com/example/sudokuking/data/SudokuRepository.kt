package com.example.sudokuking.data

import com.example.sudokuking.data.database.statisticFromDb
import com.example.sudokuking.domain.GetSudokuUseCase
import com.example.sudokuking.domain.model.Statistic
import com.example.sudokuking.domain.model.Sudoku
import com.example.sudokuking.domain.model.SudokuField
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val sudokuRepo = SudokuRepository()

class SudokuRepository @Inject constructor()
 {
     private val currentSudoku = MutableStateFlow(
         BoxedSudoku(Sudoku.create("test", createListOfSudokuFields()))
     )

    private val sudoku = listOf(Sudoku.create(
        "test",
        createListOfSudokuFields())
    ).filterNotNull()

     fun getSudoku() = sudoku

     fun observeSudoku(): Flow<Sudoku> = currentSudoku.map { it.sudoku }

     fun getAllSudokuFields(): List<SudokuField> {
         val result: MutableList<SudokuField> = mutableListOf()

         for (row in sudoku[0].sudokuFields) {
             for (field in row) {
                 result.add(field)
             }
         }
         return result
     }

     fun getSudokuFieldById(_id: Int): SudokuField? = getAllSudokuFields().firstOrNull {
         it.index == _id
     }

}

fun createListOfSudokuFields(): MutableList<MutableList<SudokuField>> {
    val sudoku: MutableList<MutableList<SudokuField>> = mutableListOf()

    for (rows in 0..8) {
        var sudokuRow: MutableList <SudokuField> = mutableListOf()
        for(columns in 0..8) {
            sudokuRow.add(SudokuField.create(isSelected = false,notes = listOf(1,2), index = rows * 10 + columns, number = rows * 10 + columns))
        }
        sudoku.add(sudokuRow)
    }
    return sudoku
}

private class BoxedSudoku(val sudoku: Sudoku) {
    override fun equals(other: Any?): Boolean = false

    override fun hashCode(): Int {
        return sudoku.hashCode()
    }
}