package com.example.sudokuking.feature.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudokuking.R

@Composable
fun UnRegStatItem(statistic: UnRegStatsUI) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
        Column {
            Text(text = "Mode " + statistic.title, fontSize = 20.sp)

            Box(modifier = Modifier
                .fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(0.3f)) {
                        Text(text = stringResource(id = R.string.statistic_resolved) + ": ")
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier
                            .background(Color.Green)
                            .padding(0.dp, 1.dp)
                            .fillMaxWidth(0.1f + 0.9f * ((statistic.resolved).toFloat() / 100))
                        ) {
                            Text(text = "" + statistic.resolved + "%")
                        }
                    }
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(0.3f)) {
                        Text(text = stringResource(id = R.string.statistic_unresolved) + ": ")
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier
                            .background(Color.Red)
                            .padding(0.dp, 1.dp)
                            .fillMaxWidth(0.1f + 0.9f * ((statistic.unresolved).toFloat() / 100))
                        ) {
                            Text("" + statistic.unresolved + "%")
                        }
                    }
                }

            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(modifier = Modifier
                    .padding(0.dp, 0.dp,10.dp,0.dp )) {
                    Row {
                        Icon(painter = painterResource(R.drawable.ic_baseline_alarm_off_24), contentDescription = "Average")
                        Text(text =  "" + statistic.averageOut)
                    }

                }
                Box(modifier = Modifier
                    .padding(0.dp, 0.dp,10.dp,0.dp )) {
                    Row {
                        Text(text =  "Best:" + statistic.bestOut)
                        Text(text = "|Amount: " + statistic.amount)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UnRegStatItem_Preview() {
    UnRegStatItem(UnRegStatsUI("easy", 30,70, 50, "13", 5, 2, "5"))
}