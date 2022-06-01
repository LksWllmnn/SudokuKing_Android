package com.example.sudokuking.domain

import com.example.sudokuking.data.network.WebService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TestConnectionUseCase(
    private val webService: WebService
) {
    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        kotlin.runCatching {
            var res: String = webService.testConnection()

        }
    }
}