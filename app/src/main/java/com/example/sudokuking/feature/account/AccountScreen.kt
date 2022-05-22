package com.example.sudokuking.feature.account

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AccountScreen() {
    Card (
        elevation = 3.dp,
        modifier = Modifier
            .padding(5.dp)
    )
    {
        Text(
            textAlign = TextAlign.Center,
            text = "Hello Account",
            color = MaterialTheme.colors.primaryVariant
        )
    }
}

@Preview
@Composable
fun AccountScreen_Preview() {
    AccountScreen()
}