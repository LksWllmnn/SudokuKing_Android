package com.example.sudokuking.data

import android.R
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.example.sudokuking.domain.model.Sudoku
import com.example.sudokuking.domain.model.SudokuField
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import java.io.ByteArrayOutputStream
import java.io.InputStream
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

     private val solvedSudoku = Sudoku.create(
             "testSolved",
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
        var sudokuRow: MutableList <SudokuField> = mutableListOf()
        for(columns in 0..8) {
            if (columns%2 == 0) sudokuRow.add(SudokuField.create(isSelected = false,notes = listOf(1,2), index = rows * 10 + columns, number =(rows * 10 + columns).toString(), isFixed = false))
            else sudokuRow.add(SudokuField.create(isSelected = false,notes = listOf(1,2), index = rows * 10 + columns, number =(rows * 10 + columns).toString(), isFixed = true))
        }
        sudoku.add(sudokuRow)
    }
    return sudoku
}

//val unsolvedAndSolvedSudoku: String = "080790010\n" +
//        "900000705\n" +
//        "000000040\n" +
//        "200070000\n" +
//        "100906002\n" +
//        "000030004\n" +
//        "030000000\n" +
//        "504000006\n" +
//        "060018030\t\t\t\t\t\t\t\n" +
//        "\t\t\t\t\t\t\n" +
//        "485792613\n" +
//        "916483725\n" +
//        "327165948\n" +
//        "259874361\n" +
//        "143956872\n" +
//        "678231594\n" +
//        "831649257\n" +
//        "594327186\n" +
//        "762518439"

private class BoxedSudoku(val sudoku: Sudoku) {
    override fun equals(other: Any?): Boolean = false

    override fun hashCode(): Int {
        return sudoku.hashCode()
    }
}

