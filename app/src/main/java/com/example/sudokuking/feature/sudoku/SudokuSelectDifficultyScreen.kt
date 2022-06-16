package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun SudokuSelectDifficultyScreen(viewModel: SudokuViewModel = viewModel(), navController: NavHostController) {
    SudokuSelectDifficultyScreenUI(navController = navController, viewModel::onLoadSudoku)
}

@Composable
fun SudokuSelectDifficultyScreenUI(navController: NavHostController, onLoadSudoku:(Int) -> Unit) {
    Card() {
        Column() {
            Button(
                onClick =
                {
                    onLoadSudoku(0)
                    navController.navigate(SudokuNavigationItem.Game.routeName)
                }
            ) {
                Text(text = "Easy")
            }
            Button(
                onClick =
                {
                    onLoadSudoku(1)
                    navController.navigate(SudokuNavigationItem.Game.routeName)
                }
            ) {
                Text(text = "Medium")
            }
            Button(
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