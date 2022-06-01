package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LoggedInScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight()
    ) {
        Card(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()) {
            Column() {
                Text(
                    text = "Account",
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Username: Test",
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
        Button(
            onClick = { navController.navigate(AccountNavigationItem.NotLoggedIn.routeName) },
            modifier = Modifier
                .padding(5.dp)
        ) {
            Text(text = "Logout")
        }

        Button(
            onClick = { navController.navigate(AccountNavigationItem.NotLoggedIn.routeName) },
            modifier = Modifier
                .padding(5.dp)
        ) {
            Text(text = "Delete Account")
        }
    }
}