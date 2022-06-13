package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudokuking.domain.model.SudokuField

@Composable
fun NumbFieldItem(setNumb: (number: Int) -> Unit) {

    Column() {
        Row() {
            Button(
                onClick = { setNumb(1) }
            ) {
                Text(text = "1")
            }
            Button(

                onClick = { setNumb(2) }) {
                Text(text = "2")
            }
            Button(

                onClick = { setNumb(3) }) {
                Text(text = "3")
            }

        }
        Row() {
            Button(

                onClick = { setNumb(4) }) {
                Text(text = "4")
            }
            Button(

                onClick = { setNumb(5) }) {
                Text(text = "5")
            }
            Button(

                onClick = { setNumb(6) }) {
                Text(text = "6")
            }
        }
        Row() {
            Button(

                onClick = { setNumb(7) }) {
                Text(text = "7")
            }
            Button(

                onClick = { setNumb(8) }) {
                Text(text = "8")
            }
            Button(

                onClick = { setNumb(9) }) {
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
}