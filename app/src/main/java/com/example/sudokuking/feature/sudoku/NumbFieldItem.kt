package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NumbFieldItem(setNumb: (number: Int) -> Unit, number: Int) {
    Box (
        modifier= Modifier
            .shadow(5.dp)
            .background(MaterialTheme.colors.primaryVariant)
            .width(40.dp)
            .height(40.dp)
            .clickable { setNumb(number) },
    )
    {
        Text(
            modifier = Modifier
                .align(alignment = Alignment.Center),
            text = "" + number,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.secondary,
        )
    }
}
