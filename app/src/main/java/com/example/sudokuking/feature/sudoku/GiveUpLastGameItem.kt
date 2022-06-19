package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GiveUpLastGamePopUp(giveUp:() -> Unit, dontGiveUp: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column() {
            Text(text = "Do you really want to give up your last game and start a new one?")
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { giveUp() }) {
                Text(text = "Give Up")
            }
            Button(
                onClick = { dontGiveUp() }) {
                Text(text = "Don't Give Up")
            }
        }

    }
}
