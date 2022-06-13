package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumbFieldItem() {

    Column(

    ) {
        Row() {
            Button(

                onClick = { /*TODO*/ }
            ) {
                Text(text = "1")
            }
            Button(

                onClick = {  }) {
                Text(text = "2")
            }
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "3")
            }

        }
        Row() {
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "4")
            }
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "5")
            }
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "6")
            }
        }
        Row() {
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "7")
            }
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "8")
            }
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "9")
            }
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Button(

                onClick = { /*TODO*/ }) {
                Text(text = "✕")
            }
        }
    }

}

@Preview
@Composable
fun NumbFieldItem_Preview() {
    NumbFieldItem()
}