package com.example.sudokuking.feature.statistic

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
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
                    best = statistic.best)
            }.sortedBy { it.title }
            emit(result)
        }
}