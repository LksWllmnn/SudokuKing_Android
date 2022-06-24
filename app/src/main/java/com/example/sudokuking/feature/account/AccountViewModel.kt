package com.example.sudokuking.feature.account

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sudokuking.domain.*
import com.example.sudokuking.domain.model.RankTitle
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountViewModel @Inject constructor(): ViewModel() {
    fun bindUI(context: Context): LiveData<AccountUI?> =
        liveData {
            val resultAccount = GetActiveAccountUseCase()()
            var result = AccountUI("","", "")
            if (resultAccount != null) {
                result.id = resultAccount.id
                result.name = resultAccount.username
                result.rankTitle = rankTitleToString(resultAccount.rankTitle)
            }
            emit(result)
        }

    fun rankTitleToString(rankTitle: RankTitle): String {
        return when (rankTitle) {
            RankTitle.Bronze -> "Bronze"
            RankTitle.Silver -> "Silver"
            RankTitle.Gold -> "Gold"
            RankTitle.Diamond -> "Diamond"
            RankTitle.Finished -> "Finished"
        }
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