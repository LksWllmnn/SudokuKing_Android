package com.example.sudokuking.data

import com.example.sudokuking.domain.model.SolvedState
import com.example.sudokuking.domain.model.Sudoku
import com.example.sudokuking.domain.model.SudokuField
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


val sudokuRepo = SudokuRepository()

class SudokuRepository @Inject constructor()
 {
     var allSudokuString = ""

     var isASudokuRunning: Boolean = false
     var startTime: Long = 0
     var runningTime: Long = 0
     var runningTimeOut: String = ""
     var attemptToGiveUp = false
     var isRegisteredGame: Boolean = false

     private val currentSudoku = MutableStateFlow(
         BoxedSudoku(Sudoku.create("test",SolvedState.NotSolved, mutableListOf(),createListOfSudokuFields()))
     )

    private val sudoku = listOf(
        Sudoku.create(
            "test",
            SolvedState.NotSolved,
            mutableListOf(),
            createListOfSudokuFields()
        )
    ).filterNotNull()


     private val solvedSudoku = Sudoku.create(
         "testSolved",
         SolvedState.Correct,
         mutableListOf(),
         createListOfSudokuFields()
     )

     fun getSudoku() = sudoku

     fun observeSudoku(): Flow<Sudoku> = currentSudoku.map { it.sudoku }

     private fun getAllSudokuFields(): List<SudokuField> {
         val result: MutableList<SudokuField> = mutableListOf()

         for (row in sudoku[0].sudokuFields) {
             for (field in row) {
                 result.add(field)
             }
         }
         return result
     }

     private fun getAllFinishedSudokuFields(): List<SudokuField> {
         val result: MutableList<SudokuField> = mutableListOf()

         for (row in solvedSudoku.sudokuFields) {
             for (field in row) {
                 result.add(field)
             }
         }
         return result
     }

     fun getSudokuFieldById(_id: Int): SudokuField? = getAllSudokuFields().firstOrNull {
         it.index == _id
     }

     fun getFinishedSudokuFieldById(_id: Int): SudokuField? = getAllFinishedSudokuFields().firstOrNull {
         it.index == _id
     }

     fun deselectSudokuFields() {
         getAllSudokuFields().forEach{
             it.isSelected = false
         }
     }

     fun getSelectedField(): SudokuField? = getAllSudokuFields().firstOrNull {
         it.isSelected
     }

}

fun createListOfSudokuFields(): MutableList<MutableList<SudokuField>> {
    val sudoku: MutableList<MutableList<SudokuField>> = mutableListOf()

    for (rows in 0..8) {
        val sudokuRow: MutableList <SudokuField> = mutableListOf()
        for(columns in 0..8) {
            if (columns%2 == 0) sudokuRow.add(SudokuField.create(isSelected = false,notes = listOf(1,2), index = rows * 10 + columns, number =(rows * 10 + columns).toString(), isFixed = false))
            else sudokuRow.add(SudokuField.create(isSelected = false,notes = listOf(1,2), index = rows * 10 + columns, number =(rows * 10 + columns).toString(), isFixed = true))
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