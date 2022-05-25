package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.sudokuking.ui.theme.LavBlue

@Composable
fun SudokuItem(sudoku: SudokuUI) {
    Card() {
        Text(text = "" + sudoku.title)
        Column() {
            Column() {
                for(rows in sudoku.sudokuFields) {
                    Row() {
                        for (field in rows) {
                            SudokuFieldItem(sudokuField = field, boxColor = MaterialTheme.colors.secondary, textColor = MaterialTheme.colors.primaryVariant)
                        }
                    }
                }
            }
        }
        /*val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(sudoku.sudokuFields) { index1 ->
                Text(text = "" + sudoku.title)
            }*/


                /*LazyRow(
                ) {
                    itemsIndexed(sudoku.sudokuFields[index1]) {index2, column ->
                        Text(text = "" + sudoku.title)
                    }
                }*/
                /*LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    itemsIndexed(sudoku.sudokuFields[index1]) { index2, column ->
                        if (index2 in 3..5) {
                            if (index1 in 3..5) {
                                SudokuFieldItem(sudokuField = sudoku.sudokuFields[index1][index2], boxColor = LavBlue, textColor = MaterialTheme.colors.primaryVariant)
                            } else {
                                SudokuFieldItem(sudokuField = sudoku.sudokuFields[index1][index2], boxColor = MaterialTheme.colors.secondary, textColor = MaterialTheme.colors.primaryVariant)
                            }
                        } else {
                            if (index1 in 3..5) {
                                SudokuFieldItem(sudokuField = sudoku.sudokuFields[index1][index2], boxColor = MaterialTheme.colors.onBackground, textColor = MaterialTheme.colors.primaryVariant)
                            } else {
                                SudokuFieldItem(sudokuField = sudoku.sudokuFields[index1][index2], boxColor = LavBlue, textColor = MaterialTheme.colors.primaryVariant)
                            }
                        }
                    }
                }*/
            }

    }
