package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudokuking.R

@Composable
fun NumbFieldContainerItem(setNumb: (number: Int) -> Unit, deleteNumb: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 5.dp, 5.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            //TODO: Making Notes in Future
            //Image(
            //        painter = painterResource(R.drawable.pencil),
            //        contentDescription = "pencil",
            //        modifier = Modifier
            //            .width(40.dp)
            //            .height(40.dp)
            //            .clickable { }
            //    )
            Image(
                painter = painterResource(R.drawable.erasor),
                contentDescription = "erase",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .clickable { deleteNumb() }
            )
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