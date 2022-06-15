package com.example.sudokuking.feature.sudoku

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sudokuking.domain.model.SolvedState
import com.example.sudokuking.domain.model.SudokuField

@Composable
fun SudokuScreen(viewModel: SudokuViewModel = viewModel()) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    SudokuScreenUI(sudokus = sudoku, viewModel::onSelectField, viewModel::onSetNumber, viewModel::onDeleteNumber, viewModel::onLoadSudoku, viewModel.isLoaded, viewModel::onCheckSudoku)
}

@Composable
fun SudokuScreenUI(sudokus: List<SudokuUI>, selectField: (SudokuField) -> Unit, setNumb: (Int) -> Unit, deleteNumb:() -> Unit, onLoadSudoku:(Context) -> Unit, isLoaded:Boolean, onCheckSudoku:()-> Unit) {
    if(!isLoaded) {
        onLoadSudoku(LocalContext.current)
    }
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
        )
    {
        val scrollState = rememberLazyListState()
        Column() {
            LazyColumn(state = scrollState,
            modifier = Modifier.height(LocalConfiguration.current.screenWidthDp.dp)) {
                items(sudokus) { sudoku ->
                    SudokuItem(sudoku = sudoku, selectField)
                    if(sudoku.isSolved == SolvedState.Wrong) {
                        Card() {
                            Text("Das war leider falsch: " + sudoku.wrongNumbers)
                        }
                    } else if (sudoku.isSolved == SolvedState.Correct) {
                        Card() {
                            Text("Das ist richtig!: " + sudoku.wrongNumbers)
                        }
                    }
                }
            }
            Row() {
                NumbFieldItem( setNumb, deleteNumb )
                Button(onClick = { onCheckSudoku() }) {
                    Text(text = "Check Sudoku")
                }
            }
        }

    }
}

@Preview
@Composable
fun SudokuScreen_Preview() {
    SudokuScreen()
}