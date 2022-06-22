package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.R
import com.example.sudokuking.feature.account.AccountUI
import com.example.sudokuking.feature.account.AccountViewModel

@Composable
fun SudokuSelectTypeScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController, viewModelAccount: AccountViewModel = viewModel()) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    val account by viewModelAccount.bindUI(LocalContext.current).observeAsState()
    SudokuSelectTypeScreenUI(sudoku, navController, viewModel::onGiveUp, viewModel::onAttemptGiveUp, viewModel::onDontGiveUp, viewModel::onLoadSudoku, account)
}

@Composable
fun SudokuSelectTypeScreenUI(sudokus: List<SudokuUI>, navController: NavHostController, giveUp: () -> Unit, attemptGiveUp: () -> Unit, dontGiveUp:() -> Unit, onLoadSudoku:(stage:Int) -> Unit, account: AccountUI?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(account?.id != "") {
                Button(
                    onClick =
                    {
                        if(sudokuRepo.isASudokuRunning) {
                            attemptGiveUp()
                        } else {
                            onLoadSudoku(4)
                            navController.navigate(SudokuNavigationItem.Game.routeName)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp),

                    ) {
                    Text(text = stringResource(R.string.sudoku_gameType_ranked))
                }
            } else {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
                    ) {
                    Text(text = stringResource(R.string.sudoku_gameType_ranked))
                }
            }

            Button(
                onClick =
                {
                    if(sudokuRepo.isASudokuRunning) {
                        attemptGiveUp()
                    } else {
                        navController.navigate(SudokuNavigationItem.SelectTypeUnranked.routeName)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp)
            ) {
                Text(text = stringResource(R.string.sudoku_gameType_unranked))
            }
            if(sudokuRepo.isASudokuRunning) {
                Button(
                    onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp)
                ) {
                    Text(text = stringResource(R.string.sudoku_gameType_continue))
                }
            } else {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
                ) {
                    Text(text = stringResource(R.string.sudoku_gameType_continue))
                }
            }
        }
        if(sudokuRepo.attemptToGiveUp) {
            GiveUpLastGamePopUp(giveUp, dontGiveUp)
        }
    }
}