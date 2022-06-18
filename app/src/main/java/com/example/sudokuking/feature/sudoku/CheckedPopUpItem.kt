package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sudokuking.domain.model.SolvedState

@Composable
fun CheckedPopUpItem(sudokus:List<SudokuUI>) {
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
                            text = "Das war leider falsch: " + sudokus[0].wrongNumbers,
                            modifier = Modifier
                                .padding(10.dp),
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Text(text = "Verstanden")
                        }
                    } else if (sudoku.isSolved == SolvedState.Correct) {
                        Text(
                            text = "Das ist richtig!: " + sudokus[0].wrongNumbers,
                            modifier = Modifier
                                .padding(10.dp),
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Text(text = "Beenden")
                        }
                    }
                }
            }
        }
    }
}
