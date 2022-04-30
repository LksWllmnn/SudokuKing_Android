package com.example.sudokuking.feature.sudoku

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sudokuking.ui.theme.LavBlue
import java.time.chrono.JapaneseEra.values

@Composable
fun SudokuScreen() {
    var num = listOf(
        listOf<Int>(1,2,3,4,5,6,7,8,9),
        listOf<Int>(11,12,13,14,15,16,17,18,19),
        listOf<Int>(21,22,23,24,25,26,27,28,29),
        listOf<Int>(31,32,33,34,35,36,37,38,39),
        listOf<Int>(41,42,43,44,45,46,47,48,49),
        listOf<Int>(51,52,53,54,55,56,57,58,59),
        listOf<Int>(61,62,63,64,65,66,67,68,69),
        listOf<Int>(71,72,73,74,75,76,77,78,79),
        listOf<Int>(81,82,83,84,85,86,87,88,89)
    )

    Card(
        elevation = 3.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        LazyColumn() {
            itemsIndexed(num) { index1, row ->
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                    ) {
                    itemsIndexed(num[index1]) { index2, column ->
                        if(index2 in 3..5) {
                            if(index1 in 3..5) {
                                Box(
                                    modifier = Modifier
                                        .border(0.5.dp, MaterialTheme.colors.onBackground)
                                        .padding(0.dp)
                                        .background(color = LavBlue)
                                        .width(Resources.getSystem().displayMetrics.xdpi.dp/11)
                                        .height(Resources.getSystem().displayMetrics.xdpi.dp / 11)
                                    ,
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .align(alignment = Alignment.Center),
                                        textAlign = TextAlign.Center,
                                        text = "" + num[index1][index2],
                                        color = MaterialTheme.colors.primaryVariant
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .border(0.5.dp, MaterialTheme.colors.onBackground)
                                        .padding(0.dp)
                                        .background(color = MaterialTheme.colors.secondary)
                                        .width(Resources.getSystem().displayMetrics.xdpi.dp/11)
                                        .height(Resources.getSystem().displayMetrics.xdpi.dp / 11)
                                    ,
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .align(alignment = Alignment.Center),
                                        textAlign = TextAlign.Center,
                                        text = "" + num[index1][index2],
                                        color = MaterialTheme.colors.primaryVariant
                                    )
                                }
                            }

                        } else {
                            if(index1 in 3..5) {
                                Box(
                                    modifier = Modifier
                                        .border(0.5.dp, MaterialTheme.colors.onBackground)
                                        .padding(0.dp)
                                        .background(color = MaterialTheme.colors.secondary)
                                        .width(Resources.getSystem().displayMetrics.xdpi.dp / 11)
                                        .height(Resources.getSystem().displayMetrics.xdpi.dp / 11),
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .align(alignment = Alignment.Center),
                                        textAlign = TextAlign.Center,
                                        text = "" + num[index1][index2],
                                        color = MaterialTheme.colors.primary
                                    )
                                }
                            } else {
                                Box(
                                    modifier = Modifier
                                        .border(0.5.dp, MaterialTheme.colors.onBackground)
                                        .padding(0.dp)
                                        .background(color = LavBlue)
                                        .width(Resources.getSystem().displayMetrics.xdpi.dp / 11)
                                        .height(Resources.getSystem().displayMetrics.xdpi.dp / 11)
                                    ,
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .align(alignment = Alignment.Center),
                                        textAlign = TextAlign.Center,
                                        text = "" + num[index1][index2],
                                        color = MaterialTheme.colors.primary
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SudokuScreen_Preview() {
    SudokuScreen()
}