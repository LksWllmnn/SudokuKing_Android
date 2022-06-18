package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SudokuSelectTypeScreen(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(10.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp),

            ) {
                Text(text = "Play Ranked")
            }
            Button(
                onClick = { navController.navigate(SudokuNavigationItem.SelectTypeUnranked.routeName) },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp)
            ) {
                Text(text = "Play Unranked")
            }
            Button(
                onClick = { navController.navigate(SudokuNavigationItem.Game.routeName) },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp)
            ) {
                Text(text = "Continue Game")
            }
        }
    }
}