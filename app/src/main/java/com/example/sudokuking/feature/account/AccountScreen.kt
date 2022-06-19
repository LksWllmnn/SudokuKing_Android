package com.example.sudokuking.feature.account


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.sudokuking.data.accountRepo

@Composable
fun AccountScreen(navController: NavHostController) {
    if(accountRepo.isLoggedIn) LoggedInScreen(navController = navController)
    else NotLoggedInScreen(navController)
}