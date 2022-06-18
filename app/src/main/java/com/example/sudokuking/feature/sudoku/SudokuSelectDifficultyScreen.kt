package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun SudokuSelectDifficultyScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController) {
    SudokuSelectDifficultyScreenUI(navController = navController, viewModel::onLoadSudoku)
}

@Composable
fun SudokuSelectDifficultyScreenUI(navController: NavHostController, onLoadSudoku:(Int) -> Unit) {
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
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),

                onClick =
                {
                    onLoadSudoku(0)
                    navController.navigate(SudokuNavigationItem.Game.routeName)
                }
            ) {
                Text(text = "Easy")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),
                onClick =
                {
                    onLoadSudoku(1)
                    navController.navigate(SudokuNavigationItem.Game.routeName)
                }
            ) {
                Text(text = "Medium")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),
                onClick =
                {
                    onLoadSudoku(2)
                    navController.navigate(SudokuNavigationItem.Game.routeName)
                }
            ) {
                Text(text = "Hard")
            }
        }
    }
}