package com.example.sudokuking.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.sudokuking.App
import kotlinx.coroutines.flow.map

class AppViewModel: ViewModel() {
    fun isLoggedIn() = App.userSettingsRepo
        .observeSettings()
        .map { it.loginState }
        .asLiveData()
}