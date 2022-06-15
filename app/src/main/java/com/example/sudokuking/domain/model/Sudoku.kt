package com.example.sudokuking.domain.model

class Sudoku private constructor(
    val title: String,
    var isSolved: SolvedState,
    var wrongNumbers: List<Int>,
    val sudokuFields: MutableList<MutableList<SudokuField>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sudoku

        if (title != other.title) return false
        if (sudokuFields != other.sudokuFields) return false

        return true
    }

    companion object {
        fun create(
            title: String,
            isSolved: SolvedState,
            wrongNumbers: List<Int>,
            sudokuFields: MutableList<MutableList<SudokuField>>
        ): Sudoku {
            return Sudoku(title, isSolved, wrongNumbers, sudokuFields)
        }
    }
}

enum class SolvedState {
    Correct, Wrong, NotSolved
}