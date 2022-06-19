package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sudokuking.R
import com.example.sudokuking.domain.model.SolvedState

@Composable
fun CheckedPopUpItem(sudokus:List<SudokuUI>, onFinish:() -> Unit, onContinueAfterWrong:() -> Unit, navController: NavHostController) {
    sudokus.forEach { sudoku ->
        if(sudoku.isSolved == SolvedState.Wrong || sudoku.isSolved == SolvedState.Correct) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(0.75f)
                        .padding(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    if (sudoku.isSolved == SolvedState.Wrong) {
                        Text(
                            text = stringResource(id = R.string.sudoku_thisWasWrong) + sudokus[0].wrongNumbers,
                            modifier = Modifier
                                .padding(10.dp),
                        )
                        Button(
                            onClick = { onContinueAfterWrong() },
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Text(text = stringResource(id = R.string.sudoku_understoodWrong))
                        }
                    } else if (sudoku.isSolved == SolvedState.Correct) {
                        Text(
                            text = stringResource(id = R.string.sudoku_thisWasRight),
                            modifier = Modifier
                                .padding(10.dp),
                        )
                        Button(
                            onClick =
                            {
                                onFinish()
                                navController.navigate(SudokuNavigationItem.SelectType.routeName)
                            },
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Text(text = stringResource(id = R.string.sudoku_understoodRight))
                        }
                    }
                }
            }
        }
    }
}
