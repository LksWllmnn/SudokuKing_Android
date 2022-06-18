package com.example.sudokuking.domain

import com.example.sudokuking.data.StatisticRepository
import com.example.sudokuking.domain.model.Statistic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class InitializeStatisticUseCase(
    private val statisticRepository: StatisticRepository,
    private val context: CoroutineContext = Dispatchers.Default,
) {
    suspend operator fun invoke() = withContext(context) {
        if (statisticRepository.getAllStatistics().isNotEmpty()) return@withContext
        listOf(
            Statistic.create("Easy",0,0,0f,0f),
            Statistic.create("Medium",0,0,0f,0f),
            Statistic.create("Hard",0,0,0f,0f)
        ).forEach{statisticRepository.addStatistic(it)}

    }
}