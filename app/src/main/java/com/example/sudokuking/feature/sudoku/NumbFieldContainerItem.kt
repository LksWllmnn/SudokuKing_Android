package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudokuking.domain.model.SudokuField

@Composable
fun NumbFieldContainerItem(setNumb: (number: Int) -> Unit, deleteNumb: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box (
                modifier= Modifier
                    .shadow(5.dp)
                    .background(MaterialTheme.colors.secondary)
                    .width(60.dp)
                    .height(40.dp)
                    .clickable {  },
            )
            {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Center),
                    text = "Note",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                )
            }
            Box (
                modifier= Modifier
                    .shadow(5.dp)
                    .background(MaterialTheme.colors.secondary)
                    .width(40.dp)
                    .height(40.dp)
                    .clickable { deleteNumb() },
            )
            {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Center),
                    text = "✕",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary,
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf(1,2,3,4,5)
                .forEach{num ->
                    NumbFieldItem(setNumb = setNumb, number = num)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf(6,7,8,9)
                .forEach{num ->
                    NumbFieldItem(setNumb = setNumb, number = num)
                }
        }
    }
}

@Preview
@Composable
fun NumbFieldItem_Preview() {
}