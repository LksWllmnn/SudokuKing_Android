package com.example.sudokuking.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.sudokuking.feature.sudoku.SudokuScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "game") {

        composable(BottomNavigationItem.Account.routeName) {
        }
        composable(BottomNavigationItem.Game.routeName) {
            SudokuScreen()
        }
        composable(BottomNavigationItem.Statistics.routeName) {
        }
    }
}
