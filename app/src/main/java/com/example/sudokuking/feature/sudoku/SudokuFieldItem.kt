package com.example.sudokuking.feature.sudoku

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sudokuking.domain.model.SudokuField



@Composable
fun SudokuFieldItem(sudokuField: SudokuField, boxColor: Color, textColor: Color, tileOffset: Float, selectField: (sudokuField: SudokuField) -> Unit) {
    Box(
        modifier = Modifier
            .border(0.5.dp, MaterialTheme.colors.onBackground)
            .padding(0.dp)
            .background(color = boxColor)
            .clickable { selectField(sudokuField) },
    )
    {
        Column {
            Box(modifier = Modifier
                .width(tileOffset.dp)
                .height((tileOffset*1.0).dp)
            ) {
                var fontWeight = FontWeight.Normal
                if(sudokuField.isFixed) fontWeight = FontWeight.ExtraBold
                Text(
                  modifier = Modifier
                      .align(alignment = Alignment.Center),
                  textAlign = TextAlign.Center,
                  color = textColor,
                  text = "" + sudokuField.number,
                  fontWeight = fontWeight
                )
            }

            //TODO: Make Noteation Function in Future
            //Box(modifier = Modifier
            //       .height((tileOffset*0.3).dp)
            //
            //     {
            //        Text(text = ""  + sudokuField.notes,fontSize = 10.sp)
            //    }
        }
    }
}