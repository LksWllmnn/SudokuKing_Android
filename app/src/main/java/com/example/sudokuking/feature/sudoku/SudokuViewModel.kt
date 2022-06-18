package com.example.sudokuking.feature.sudoku

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sudokuking.domain.*
import com.example.sudokuking.domain.model.SudokuField
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SudokuViewModel @Inject constructor(): ViewModel() {
    private var isLoaded: Boolean = false

    fun bindUI(context: Context): LiveData<List<SudokuUI>> =
        liveData {
            val result = GetSudokuUseCase()().map { sudoku ->
                SudokuUI(
                    title = sudoku.title,
                    isSolved = sudoku.isSolved,
                    wrongNumbers = sudoku.wrongNumbers,
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

    fun onSetNumber(number: Int) {
        viewModelScope.launch {
            SetNewNumberUseCase()(number)
        }
    }

    fun onDeleteNumber() {
        viewModelScope.launch {
            DeleteNumberUseCase()()
        }
    }

    fun onLoadSudoku(stage:Int) {
        viewModelScope.launch {
            LoadSudokuFromFileUseCase()(stage)
        }
        this.isLoaded = true
    }

    fun onCheckSudoku() {
        viewModelScope.launch {
            CheckSudokuUseCase()()
        }
    }

    fun onFinishSolved() {
        viewModelScope.launch {
            FinishSolvedUseCase()()
        }
    }

    fun onContinueAfterWrong() {
        viewModelScope.launch {
            ContinueAfterWrongUseCase()()
        }
    }

    fun onUpdateGameTime() {
        viewModelScope.launch {
            UpdateGameTimeUseCase()()
        }
    }
}

