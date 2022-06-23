package com.example.sudokuking.domain

import com.example.sudokuking.data.regStatisticRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetRegStatisticUseCase {
    suspend operator fun invoke() = withContext(Dispatchers.Default) { regStatisticRepo.getAllRegStatistics() }
}