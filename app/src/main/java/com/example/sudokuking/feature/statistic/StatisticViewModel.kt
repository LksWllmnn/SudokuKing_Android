package com.example.sudokuking.feature.statistic

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sudokuking.data.sudokuRepo
import com.example.sudokuking.domain.GetStatisticUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StatisticViewModel @Inject constructor(): ViewModel() {
    fun bindUI(context: Context): LiveData<List<UnRegStatsUI>> =
        liveData {
            val result = GetStatisticUseCase()().map { statistic ->
                UnRegStatsUI(
                    title = statistic.title,
                    resolved = statistic.resolved,
                    unresolved = statistic.unresolved,
                    average = statistic.average,
                    best = statistic.best,
                    amount = statistic.amount,
                    averageOut = computeLongToOutput(statistic.average),
                    bestOut = computeLongToOutput(statistic.best),
                )
            }
            emit(result)
        }

    private fun computeLongToOutput(num:Long): String {
        var result: String = ""
        if (((num)/60) < 10) {
            if (((num)%60) < 10) {
                result = "0" +((num)/60) + ":0" + ((num)%60)
            } else {
                result = "0" +((num)/60) + ":" + ((num)%60)
            }
        } else if (((num)%60) < 10) {
            result = "" + ((num)/60) + ":0" + ((num)%60)
        } else {
            result = "" + ((num)/60) + ":" + ((num)%60)
        }
        return result
    }
}