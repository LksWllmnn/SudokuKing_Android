package com.example.sudokuking.domain

import com.example.sudokuking.App
import com.example.sudokuking.data.StatisticRepository
import com.example.sudokuking.data.database.StatisticDb
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
            Statistic.create("Easy",45,55,13.5f,5.5f),
            Statistic.create("Medium",35,65,14.5f,6.5f),
            Statistic.create("Hard",25,75,15.5f,7.5f)
        ).forEach{statisticRepository.addStatistic(it)}

    }
}