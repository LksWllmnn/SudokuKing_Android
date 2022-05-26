package com.example.sudokuking.feature

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sudokuking.feature.account.AccountNavigationItem
import com.example.sudokuking.feature.navigation.BottomNavigationItem.Account
import com.example.sudokuking.feature.navigation.BottomNavigationItem.Statistics
import com.example.sudokuking.feature.navigation.BottomNavigationItem.Game
import com.example.sudokuking.feature.navigation.MainBottomNavigation
import com.example.sudokuking.feature.navigation.MainNavigationGraph

@Composable
fun MainScreen() {
    MainScreenUI()
}

@Composable
fun MainScreenUI() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            TopAppBar(
                title = {
                    when (currentRoute) {
                        Account.routeName -> Text(stringResource(Account.title))
                        Statistics.routeName -> Text(stringResource(Statistics.title))
                        Game.routeName -> Text(stringResource(Game.title))
                        AccountNavigationItem.NotLoggedIn.routeName -> Text("Account - Not Logged In")
                        AccountNavigationItem.Login.routeName -> Text("Account - Login")
                        AccountNavigationItem.Register.routeName -> Text("Account - Register")
                        AccountNavigationItem.LoggedIn.routeName -> Text("Account - Your Account")
                    }
                },
            )
        },
        bottomBar = { MainBottomNavigation(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier
            .border(width=2.dp, color = MaterialTheme.colors.secondary )
            .padding(innerPadding)) {
            MainNavigationGraph(navController)
        }
    }
}

@Composable
@Preview
fun MainScreen_Preview() {
    MainScreenUI()
}