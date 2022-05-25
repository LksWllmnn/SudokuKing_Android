package com.example.sudokuking.feature.sudoku

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sudokuking.domain.model.SudokuField
import com.example.sudokuking.ui.theme.LavBlue

@Composable
fun SudokuFieldItem(sudokuField: SudokuField, boxColor: Color, textColor: Color) {
    Box(modifier = Modifier
        .border(0.5.dp, MaterialTheme.colors.onBackground)
        .padding(0.dp)
        .background(color = boxColor)) {
        Column() {
            Box() {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.Center),
                    textAlign = TextAlign.Center,
                    color = textColor,
                    text = "" + sudokuField.number
                )
            }
            Box() {
                var notesString: String = ""
                if(sudokuField.notes != null) {
                    for(note in sudokuField.notes) {
                        notesString += "" + sudokuField.notes[note] + ","
                    }
                }
                Text(text = notesString)
            }
        }
    }
}