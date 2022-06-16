package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun SudokuSelectTypeScreen(navController: NavHostController) {
    Card() {
        Column() {
            Button(onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) }) {
                Text(text = "Play Ranked")
            }
            Button(onClick = { navController.navigate(SudokuNavigationItem.SelectTypeUnranked.routeName) }) {
                Text(text = "Play Unranked")
            }
            Button(onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) }) {
                Text(text = "Continue Game")
            }
        }
    }
}