package com.example.sudokuking.feature.sudoku

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudokuking.ui.theme.LavBlue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sudokuking.data.createListOfSudokuFields
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SudokuField

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