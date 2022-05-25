package com.example.sudokuking.feature.sudoku

import com.example.sudokuking.domain.model.SudokuField

class SudokuUI (
    val title: String,
    val sudokuFields: MutableList<MutableList<SudokuField>>
)