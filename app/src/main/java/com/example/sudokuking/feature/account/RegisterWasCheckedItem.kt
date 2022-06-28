package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudokuking.data.accountRepo

@Composable
fun RegisterWasCheckedPopUpItem(navController:NavController, closePupUp: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.75f),
            backgroundColor = MaterialTheme.colors.secondary) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                if(accountRepo.accountIsRegistered) {
                    Text(text = "You are successfully registered!",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .height(50.dp),
                        onClick =
                        {
                            closePupUp()
                            navController.navigate(AccountNavigationItem.NotLoggedIn.routeName)
                        })
                    {
                        Text("Go to Loggin")
                    }
                } else {
                    Text(text = "Something went wrong",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .height(50.dp),
                        onClick =
                        {
                            closePupUp()
                        })
                    {
                        Text("Try Again")
                    }
                }
            }
        }
    }


}