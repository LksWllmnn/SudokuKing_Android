package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sudokuking.domain.model.SudokuField
import com.example.sudokuking.R
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SolvedState
import com.example.sudokuking.feature.account.AccountUI
import com.example.sudokuking.feature.account.AccountViewModel

@Composable
fun SudokuScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController, viewModelAccount: AccountViewModel = viewModel()) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    val account by viewModelAccount.bindUI(LocalContext.current).observeAsState()
    SudokuScreenUI(sudokus = sudoku, viewModel::onSelectField, viewModel::onSetNumber, viewModel::onDeleteNumber, viewModel::onCheckSudoku, viewModel::onFinishSolved, viewModel::onContinueAfterWrong, navController, viewModel::onUpdateGameTime, account)
}

@Composable
fun SudokuScreenUI(sudokus: List<SudokuUI>, selectField: (SudokuField) -> Unit, setNumb: (Int) -> Unit, deleteNumb:() -> Unit, onCheckSudoku:()-> Unit, onFinish:() -> Unit, onContinueAfterWrong:() -> Unit, navController: NavHostController, onUpdateGameTime:() -> Unit, account: AccountUI?) {
    sudokus.forEach { sudoku ->
        if (sudoku.isSolved == SolvedState.NotSolved) {
            onUpdateGameTime()
        }
    }
    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
        )
    {
        val scrollState = rememberLazyListState()
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row {
                        Icon(painterResource(id = R.drawable.ic_baseline_timer_24), contentDescription = "Running Time")
                        Text(sudokuRepo.runningTimeOut)
                    }
                }
                Image(
                    painter = painterResource(R.drawable.check),
                    contentDescription = "Check Sudoku",
                    modifier = Modifier
                        .width(52.dp)
                        .height(39.dp)
                        .shadow(5.dp)
                        .clickable {
                            onCheckSudoku()
                        }
                )
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