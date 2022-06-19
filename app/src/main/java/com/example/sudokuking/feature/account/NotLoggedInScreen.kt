package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sudokuking.R

@Composable
fun NotLoggedInScreen (navController: NavHostController) {
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight() ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.75f),
            backgroundColor = MaterialTheme.colors.secondary
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = stringResource(R.string.account_not_logged_in),
                    modifier = Modifier
                        .padding(5.dp),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = { navController.navigate(AccountNavigationItem.Login.routeName)},
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp)
                ) {
                    Text(text = stringResource(R.string.account_loggIn_button))
                }

                Button(
                    onClick = { navController.navigate(AccountNavigationItem.Register.routeName) },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp)
                ) {
                    Text(text = stringResource(R.string.account_register_button))
                }
            }
        }

    }
}