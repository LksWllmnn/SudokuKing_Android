package com.example.sudokuking.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.sudokuking.feature.account.*
import com.example.sudokuking.feature.statistic.StatisticScreen
import com.example.sudokuking.feature.sudoku.SudokuNavigationItem
import com.example.sudokuking.feature.sudoku.SudokuScreen
import com.example.sudokuking.feature.sudoku.SudokuSelectDifficultyScreen
import com.example.sudokuking.feature.sudoku.SudokuSelectTypeScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "game") {

        composable(BottomNavigationItem.Account.routeName) {
            AccountScreen(navController)
        }
        composable(BottomNavigationItem.Game.routeName) {
            SudokuSelectTypeScreen(navController = navController)
        }
        composable(BottomNavigationItem.Statistics.routeName) {
            StatisticScreen()
        }

        //Account
        composable(AccountNavigationItem.NotLoggedIn.routeName) {
            NotLoggedInScreen(navController = navController)
        }

        composable(AccountNavigationItem.Login.routeName) {
            LoginScreen(navController = navController)
        }

        composable(AccountNavigationItem.Register.routeName) {
            RegisterScreen(navController = navController)
        }

        composable(AccountNavigationItem.LoggedIn.routeName) {
            LoggedInScreen(navController = navController)
        }

        //Sudoku
        composable(SudokuNavigationItem.SelectTypeUnranked.routeName) {
            SudokuSelectDifficultyScreen(navController = navController)
        }

        composable(SudokuNavigationItem.Game.routeName) {
            SudokuScreen()
        }
    }
}
