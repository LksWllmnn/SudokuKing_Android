package com.example.sudokuking.feature.sudoku

sealed class SudokuNavigationItem {
    abstract val routeName: String

    object SelectType : SudokuNavigationItem() {
        override val routeName = "SelectType"
    }

    object SelectTypeUnranked : SudokuNavigationItem() {
        override val routeName = "SelectTypeUnranked"
    }

    object Game : SudokuNavigationItem() {
        override val routeName = "PlayGame"
    }
}