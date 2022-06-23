package com.example.sudokuking.feature.account

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sudokuking.domain.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(): ViewModel() {
    fun bindUI(context: Context): LiveData<AccountUI?> =
        liveData {
            val resultAccount = GetActiveAccountUseCase()()
            var result = AccountUI("","")
            if (resultAccount != null) {
                result.id = resultAccount.id
                result.name = resultAccount.username
            }
            emit(result)
        }

    fun onCheckInputs(name:String, password: String) {
        viewModelScope.launch {
            CheckAccountInputsUseCase()(name, password)
        }
    }

    fun onLoggOut() {
        viewModelScope.launch {
            LoggOutUseCase()()
        }
    }

    fun onDeleteAccount() {
        viewModelScope.launch {
            DeleteAccountUseCase()()
        }
    }

    fun onRegister(name: String, password: String) {
        viewModelScope.launch {
            RegisterAccountUseCase()(name, password)
        }
    }

    fun onCloseRegisterPopUp() {
        viewModelScope.launch {
            CloseRegisterPopUpUseCase()()
        }
    }
}