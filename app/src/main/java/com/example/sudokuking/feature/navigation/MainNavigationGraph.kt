package com.example.sudokuking.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.sudokuking.feature.account.*
import com.example.sudokuking.feature.statistic.StatisticScreen
import com.example.sudokuking.feature.sudoku.SudokuScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "statistics") {

        composable(BottomNavigationItem.Account.routeName) {
            AccountScreen(navController)
        }
        composable(BottomNavigationItem.Game.routeName) {
            SudokuScreen()
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
    }
}
