package com.example.sudokuking.domain

import com.example.sudokuking.data.GameResultRepository
import com.example.sudokuking.domain.model.GameResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext

class InitialiseGameResultsUseCase(
    private val gameResultsRepository: GameResultRepository,
    private val context: CoroutineContext = Dispatchers.Default,
) {
    suspend operator fun invoke() = withContext(context) {
        if (gameResultsRepository.getAllGameResults().isNotEmpty()) return@withContext
        gameResultsRepository.addGameResult(GameResult.create(UUID.randomUUID().toString(), true, 0, "easy", 0))
    }
}