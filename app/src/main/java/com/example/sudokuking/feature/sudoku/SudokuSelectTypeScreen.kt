package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.model.SudokuField

@Composable
fun SudokuSelectTypeScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController) {
    val sudoku by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    SudokuSelectTypeScreenUI(sudoku, navController, viewModel::onGiveUp, viewModel::onAttemptGiveUp, viewModel::onDontGiveUp, viewModel::onLoadSudoku)
}

@Composable
fun SudokuSelectTypeScreenUI(sudokus: List<SudokuUI>, navController: NavHostController, giveUp: () -> Unit, attemptGiveUp: () -> Unit, dontGiveUp:() -> Unit, onLoadSudoku:(stage:Int) -> Unit) {
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
                Text(text = "Play Ranked")
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
                Text(text = "Play Unranked")
            }
            if(sudokuRepo.isASudokuRunning) {
                Button(
                    onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp)
                ) {
                    Text(text = "Continue Game")
                }
            } else {
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
                ) {
                    Text(text = "Continue Game")
                }
            }

        }
        if(sudokuRepo.attemptToGiveUp) {
            GiveUpLastGamePopUp(giveUp, dontGiveUp)
        }
    }
}