package com.example.sudokuking.feature.sudoku

import com.example.sudokuking.domain.model.SolvedState
import com.example.sudokuking.domain.model.SudokuField

class SudokuUI (
    val title: String,
    val isSolved: SolvedState,
    val wrongNumbers: List<Int>,
    val sudokuFields: MutableList<MutableList<SudokuField>>
)