package com.example.sudokuking.feature.sudoku

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sudokuking.domain.GetSudokuUseCase
import com.example.sudokuking.domain.SelectSudokuField
import com.example.sudokuking.domain.model.SudokuField
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SudokuViewModel @Inject constructor(): ViewModel() {
    fun bindUI(context: Context): LiveData<List<SudokuUI>> =
        liveData {
            val result = GetSudokuUseCase()().map { sudoku ->
                SudokuUI(
                    title = sudoku.title,
                    sudokuFields = sudoku.sudokuFields
                )
            }
            emit(result)
        }

    fun onSelectField(sudokuField: SudokuField) {
        viewModelScope.launch {
            SelectSudokuField()(sudokuField)
        }
    }
}