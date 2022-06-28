package com.example.sudokuking.feature.sudoku

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
import com.example.sudokuking.R

@Composable
fun GiveUpLastGamePopUp(giveUp:() -> Unit, dontGiveUp: () -> Unit) {
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
                .fillMaxHeight(),
            backgroundColor = MaterialTheme.colors.secondary)
        {
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround)
            {
                Text(
                    text = stringResource(id = R.string.sudoku_giveUpQuestion),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp)
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp),
                    onClick = { giveUp() }) {
                    Text(text = stringResource(id = R.string.sudoku_giveUpButton))
                }
                Button(
                    onClick = { dontGiveUp() },
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .height(50.dp))
                {
                    Text(text = stringResource(id = R.string.sudoku_dontGiveUpButton))
                }
            }

        }
    }
}
