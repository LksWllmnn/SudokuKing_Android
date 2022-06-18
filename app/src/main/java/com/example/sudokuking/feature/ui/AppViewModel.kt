package com.example.sudokuking.feature.ui

import android.content.Context
import androidx.lifecycle.*
import com.example.sudokuking.domain.PreLoadAllSudokusUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppViewModel @Inject constructor(): ViewModel() {
    fun onPreLoadAllSudokus(context: Context) {
        viewModelScope.launch {
            PreLoadAllSudokusUseCase()(context)
        }
    }
}