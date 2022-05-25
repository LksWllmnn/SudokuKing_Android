package com.example.sudokuking.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.sudokuking.data.statisticRepo

class GetStatisticUseCase {
    suspend operator fun invoke() = withContext(Dispatchers.Default) { statisticRepo.getAllStatistics() }

}