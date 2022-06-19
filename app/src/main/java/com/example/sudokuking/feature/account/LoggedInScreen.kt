package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun LoggedInScreen(viewModel: AccountViewModel = viewModel(), navController: NavHostController) {
    val account by viewModel.bindUI(LocalContext.current).observeAsState()
    LoggedInScreenUi(navController, account, viewModel::onLoggOut)
}

@Composable
fun LoggedInScreenUi(navController: NavHostController, account: AccountUI?, loggOut:() -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.5f),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Account",
                    fontSize = 35.sp,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Text(
                    text = "Username: " + account?.name,
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
        Button(
            onClick =
            {
                loggOut()
                navController.navigate(AccountNavigationItem.NotLoggedIn.routeName)
            },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(0.75f)
        ) {
            Text(text = "Logout")
        }

        Button(
            onClick = { navController.navigate(AccountNavigationItem.NotLoggedIn.routeName) },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(0.75f)
        ) {
            Text(text = "Delete Account")
        }
    }
}