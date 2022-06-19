package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudokuking.data.accountRepo

@Composable
fun LoggInInputsWereCheckedPopUpItem(correct: Boolean, navController: NavController) {
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
                verticalArrangement = Arrangement.Center
            ) {
                if(correct) {
                    Text(text = "That was correct")
                    Button(onClick =
                    {
                        accountRepo.inputsWereChecked = false
                        navController.navigate(AccountNavigationItem.LoggedIn.routeName)
                    }) {
                        Text("Continue")
                    }
                } else {
                    Text(text = "That was wrong")
                    Button(onClick =
                    {
                        accountRepo.inputsWereChecked = false
                    }) {
                        Text("Try Again")
                    }
                }
            }
        }
    }


}