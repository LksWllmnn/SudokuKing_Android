package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.sudokuking.R

@Composable
fun GiveUpLastGamePopUp(giveUp:() -> Unit, dontGiveUp: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column {
            Text(text = stringResource(id = R.string.sudoku_giveUpQuestion))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { giveUp() }) {
                Text(text = stringResource(id = R.string.sudoku_giveUpButton))
            }
            Button(
                onClick = { dontGiveUp() }) {
                Text(text = stringResource(id = R.string.sudoku_dontGiveUpButton))
            }
        }

    }
}
