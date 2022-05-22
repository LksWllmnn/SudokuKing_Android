package com.example.sudokuking.domain

import com.example.sudokuking.data.AccountsRepository
import com.example.sudokuking.data.StatisticRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/*class ObserveStatisticsUseCase @Inject constructor(
    private val statisticRepository: StatisticRepository
) {
    operator fun invoke() = statisticRepository.observeAllStatistics().flowOn(Dispatchers.Default)
}*/