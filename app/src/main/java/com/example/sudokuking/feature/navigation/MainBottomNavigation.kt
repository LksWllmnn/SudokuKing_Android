package com.example.sudokuking.feature.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainBottomNavigation(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        listOf(
            BottomNavigationItem.Statistics,
            BottomNavigationItem.Game,
            BottomNavigationItem.Account,
        ).forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.routeName,
                icon = {
                    Icon(painter = painterResource(navItem.icon), contentDescription = navItem.routeName)
                },
                onClick = {
                    navController.navigate(navItem.routeName)
                },
            )
        }
    }
}