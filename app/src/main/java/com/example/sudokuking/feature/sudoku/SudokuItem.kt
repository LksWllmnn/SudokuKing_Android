package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sudokuking.domain.model.SudokuField
import com.example.sudokuking.ui.theme.LavBlue

//Reference: BracketCove(Ryan Michael Kay) https://github.com/BracketCove/GraphSudokuOpen/blob/master/app/src/main/java/com/bracketcove/graphsudoku/ui/activegame/ActiveGameScreen.kt (26.05.2022)
//https://www.youtube.com/watch?v=Ed5NBFrhfWU

@Composable
fun SudokuItem(sudoku: SudokuUI, selectField: (SudokuField) -> Unit) {

    Card {
        Column {
            BoxWithConstraints {
                val screenWidth = with(LocalDensity.current) {
                    constraints.maxWidth.toDp()
                }

                val margin = with(LocalDensity.current) {
                    when {
                        constraints.maxHeight.toDp().value < 500f -> 20
                        constraints.maxHeight.toDp().value < 550f -> 8
                        else -> 0
                    }
                }

                ConstraintLayout {
                    val (board) = createRefs()

                    Column(modifier = Modifier
                        .constrainAs(board) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                    ) {
                        val tileOffset = (screenWidth.value - margin) / 9
                        for (row in 0 until sudoku.sudokuFields.count()) {
                            Row {
                                for (field in 0 until sudoku.sudokuFields[row].count()) {
                                    if (field in 3..5) {
                                        if (row in 3..5) {
                                            var color: Color = LavBlue
                                            if(sudoku.sudokuFields[row][field].isSelected) {
                                                color = Color(0xFFD9CAB3)
                                            }
                                            SudokuFieldItem(
                                                sudokuField = sudoku.sudokuFields[row][field],
                                                boxColor = color,
                                                textColor = MaterialTheme.colors.primaryVariant,
                                                tileOffset,
                                                selectField
                                            )
                                        } else {
                                            var color: Color = MaterialTheme.colors.secondary
                                            if(sudoku.sudokuFields[row][field].isSelected) {
                                                color = Color(0xFFD9CAB3)
                                            }
                                            SudokuFieldItem(
                                                sudokuField = sudoku.sudokuFields[row][field],
                                                boxColor = color,
                                                textColor = MaterialTheme.colors.primaryVariant,
                                                tileOffset,
                                                selectField
                                            )
                                        }
                                    } else {
                                        if (row in 3..5) {
                                            var color: Color = MaterialTheme.colors.secondary
                                            if(sudoku.sudokuFields[row][field].isSelected) {
                                                color = Color(0xFFD9CAB3)
                                            }
                                            SudokuFieldItem(
                                                sudokuField = sudoku.sudokuFields[row][field],
                                                boxColor = color,
                                                textColor = MaterialTheme.colors.primaryVariant,
                                                tileOffset,
                                                selectField
                                            )
                                        } else {
                                            var color: Color = LavBlue
                                            if(sudoku.sudokuFields[row][field].isSelected) {
                                                color = Color(0xFFD9CAB3)
                                            }
                                            SudokuFieldItem(
                                                sudokuField = sudoku.sudokuFields[row][field],
                                                boxColor = color,
                                                textColor = MaterialTheme.colors.primaryVariant,
                                                tileOffset,
                                                selectField
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}