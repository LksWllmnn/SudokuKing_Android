package com.example.sudokuking.feature.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sudokuking.R
import com.example.sudokuking.feature.account.AccountUI

@Composable
fun RegStatItem(statistic: RegStatUI, activeAccount: AccountUI) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp))
    {
        Column {

            Box(modifier = Modifier
                .fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth(0.3f)) {
                        Text(text = activeAccount.rankTitle + ": ")
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier
                            .background(Color.Yellow)
                            .padding(0.dp, 1.dp)
                            .fillMaxWidth(0.1f + 0.9f * ((activeAccount.progress).toFloat() / 100))
                        ) {
                            Text(text = "" + activeAccount.progress + "%")
                        }
                    }
                }
            }
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
        }
    }
}