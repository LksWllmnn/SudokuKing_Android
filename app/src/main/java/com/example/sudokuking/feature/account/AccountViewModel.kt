package com.example.sudokuking.feature.account

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sudokuking.domain.CheckAccountInputsUseCase
import com.example.sudokuking.domain.GetActiveAccountUseCase
import com.example.sudokuking.domain.GetAllAccountsUseCase
import com.example.sudokuking.domain.LoggOutUseCase
import com.example.sudokuking.domain.model.Account
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(): ViewModel() {
    fun bindUI(context: Context): LiveData<AccountUI?> =
        liveData {
            val resultAccount = GetActiveAccountUseCase()()
            var result: AccountUI = AccountUI("","")
            if (resultAccount != null) {
                result.id = resultAccount.id
                result.name = resultAccount.username
            }
            //val result = GetAllAccountsUseCase()().map { account ->
            //    AccountUI(
            //        id = account.id,
            //        name = account.username
            //    )
            //}
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

    fun deleteAccount() {
        viewModelScope.launch {  }
    }
}