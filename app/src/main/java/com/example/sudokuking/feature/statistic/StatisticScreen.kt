package com.example.sudokuking.feature.statistic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sudokuking.R
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StatisticScreen(viewModel: StatisticViewModel = viewModel()) {
    val statistics by viewModel.bindUI(LocalContext.current).observeAsState(emptyList())
    StatisticScreenUI(statistics)
}

@Composable
fun StatisticScreenUI(statistics: List<UnRegStatsUI>) {
    Column(modifier = Modifier
        .padding(5.dp)) {
        Card(modifier = Modifier
            .padding(5.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            {
                Box(modifier = Modifier
                    .padding(5.dp)) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = stringResource(R.string.statistic_unregisteredStats_Title),
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 25.sp
                    )
                }
                val scrollState = rememberLazyListState()
                LazyColumn(
                    state = scrollState,
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    items(statistics) { statistic ->
                        if(statistic.amount > 0) UnRegStatItem(statistic)
                    }
                }
            }
        }

        Card(modifier = Modifier
            .padding(5.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)) {

                Box(modifier = Modifier
                    .padding(5.dp)) {
                    Text(
                        text = stringResource(R.string.statistic_registeredStats_Title),
                        color = MaterialTheme.colors.primaryVariant,
                        fontSize = 25.sp
                    )
                }
                Box(modifier = Modifier
                    .padding(5.dp)) {
                    Text(
                        text = stringResource(R.string.account_not_logged_in)
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun StatisticScreen_Preview() {
    StatisticScreen()
}