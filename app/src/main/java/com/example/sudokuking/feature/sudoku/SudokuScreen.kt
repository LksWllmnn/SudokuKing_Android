package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sudokuking.domain.model.SudokuField
import com.example.sudokuking.R

@Composable
fun SudokuScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    SudokuScreenUI(sudokus = sudoku, viewModel::onSelectField, viewModel::onSetNumber, viewModel::onDeleteNumber, viewModel::onLoadSudoku, viewModel.isLoaded, viewModel::onCheckSudoku, viewModel::onFinishSolved, viewModel::onContinueAfterWrong, navController)
}

@Composable
fun SudokuScreenUI(sudokus: List<SudokuUI>, selectField: (SudokuField) -> Unit, setNumb: (Int) -> Unit, deleteNumb:() -> Unit, onLoadSudoku:(Int) -> Unit, isLoaded:Boolean, onCheckSudoku:()-> Unit, onFinish:() -> Unit, onContinueAfterWrong:() -> Unit, navController: NavHostController) {
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
        )
    {
        val scrollState = rememberLazyListState()
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box() {
                    Row() {
                        Icon(painterResource(id = R.drawable.ic_baseline_timer_24), contentDescription = "Running Time")
                        Text("00:00")
                    }
                }
                Button(onClick = { onCheckSudoku() }) {
                    Text(text = "Check Sudoku")
                }
            }

            LazyColumn(state = scrollState,
            modifier = Modifier
                .height(LocalConfiguration.current.screenWidthDp.dp)
                .padding(5.dp)
            ) {
                items(sudokus) { sudoku ->
                    SudokuItem(sudoku = sudoku, selectField)
                }
            }
            NumbFieldContainerItem( setNumb, deleteNumb )
        }
    }
    CheckedPopUpItem(sudokus = sudokus, onFinish, onContinueAfterWrong, navController)
}