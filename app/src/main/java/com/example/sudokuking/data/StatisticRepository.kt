package com.example.sudokuking.data

import com.example.sudokuking.domain.model.Statistic
import javax.inject.Inject

val statisticRepo = StatisticRepository()

class StatisticRepository @Inject constructor(
) {
    private var allStatistics: List<Statistic> = listOf(
        Statistic.create(
            title = "easy",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            gameResults = mutableListOf()
        ),
        Statistic.create(
            title = "medium",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            gameResults = mutableListOf()
        ),
        Statistic.create(
            title = "hard",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            gameResults = mutableListOf()
        ),

    )
    fun getAllStatistics(): List<Statistic> {
        return allStatistics
    }
}