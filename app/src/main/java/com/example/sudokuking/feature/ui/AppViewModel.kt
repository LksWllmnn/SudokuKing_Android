package com.example.sudokuking.feature.ui

import android.content.Context
import androidx.constraintlayout.compose.DesignElements.map
import androidx.lifecycle.*
import com.example.sudokuking.App
import com.example.sudokuking.data.SudokuRepository
import com.example.sudokuking.domain.GetSudokuUseCase
import com.example.sudokuking.domain.PreLoadAllSudokusUseCase
import com.example.sudokuking.domain.SelectSudokuField
import com.example.sudokuking.feature.sudoku.SudokuUI
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppViewModel @Inject constructor(): ViewModel() {
    fun onPreLoadAllSudokus(context: Context) {
        viewModelScope.launch {
            PreLoadAllSudokusUseCase()(context)
        }
    }
}