package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SudokuScreen(viewModel: SudokuViewModel = viewModel()) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    SudokuScreenUI(sudokus = sudoku)
}

@Composable
fun SudokuScreenUI(sudokus: List<SudokuUI>) {
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        val scrollState = rememberLazyListState()
        LazyColumn(state = scrollState) {
            items(sudokus) {sudoku ->
                SudokuItem(sudoku = sudoku)
            }
        }
    }
}

@Preview
@Composable
fun SudokuScreen_Preview() {
    SudokuScreen()
}