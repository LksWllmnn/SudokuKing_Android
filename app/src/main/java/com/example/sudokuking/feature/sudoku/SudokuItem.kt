package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sudokuking.ui.theme.LavBlue
import java.lang.Math.sqrt

//Reference: BracketCove(Ryan Michael Kay) https://github.com/BracketCove/GraphSudokuOpen/blob/master/app/src/main/java/com/bracketcove/graphsudoku/ui/activegame/ActiveGameScreen.kt (26.05.2022)
//https://www.youtube.com/watch?v=Ed5NBFrhfWU

@Composable
fun SudokuItem(sudoku: SudokuUI) {
    Card() {
        Column() {
            BoxWithConstraints() {
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



                        for(row in 0 until sudoku.sudokuFields.count()) {
                            Row() {
                                for (field in 0 until sudoku.sudokuFields[row].count()) {
                                    if (field in 3..5) {
                                        if (row in 3..5) {
                                            SudokuFieldItem(sudokuField = sudoku.sudokuFields[row][field], boxColor = LavBlue, textColor = MaterialTheme.colors.primaryVariant, tileOffset)
                                        } else {
                                            SudokuFieldItem(sudokuField = sudoku.sudokuFields[row][field], boxColor = MaterialTheme.colors.secondary, textColor = MaterialTheme.colors.primaryVariant, tileOffset)
                                        }
                                    } else {
                                        if (row in 3..5) {
                                            SudokuFieldItem(sudokuField = sudoku.sudokuFields[row][field], boxColor = MaterialTheme.colors.secondary, textColor = MaterialTheme.colors.primaryVariant, tileOffset)
                                        } else {
                                            SudokuFieldItem(sudokuField = sudoku.sudokuFields[row][field], boxColor = LavBlue, textColor = MaterialTheme.colors.primaryVariant, tileOffset)
                                        }
                                    }
                                }
                            }
                        }
                        //BoardGrid(boundary = 9, tileOffset = tileOffset)
                    }
                }
            }

        }

    }

}

@Composable
fun BoardGrid(boundary: Int, tileOffset: Float) {
    (1 until boundary).forEach {
        val width = if (it % sqrt(boundary.toDouble()).toInt() == 0) 3.dp
        else 1.dp
        Divider(
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .absoluteOffset((tileOffset * it).dp, 0.dp)
                .fillMaxHeight()
                .width(width)
        )

        val height = if (it % sqrt(boundary.toDouble()).toInt() == 0) 3.dp
        else 1.dp
        Divider(
            color = MaterialTheme.colors.primaryVariant,
            modifier = Modifier
                .absoluteOffset(0.dp, (tileOffset * it).dp)
                .fillMaxWidth()
                .height(height)
        )
    }
}
