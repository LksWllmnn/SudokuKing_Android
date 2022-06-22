package com.example.sudokuking.data

import com.example.sudokuking.domain.model.RegStatistic
import javax.inject.Inject

val regStatisticRepo = RegStatisticRepository()

class RegStatisticRepository @Inject constructor() {
    private var allRegStatistics: List<RegStatistic> = listOf(
        RegStatistic.create(
            title = "easy",
            accountID = "",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            regGameResults = mutableListOf()
        ),
        RegStatistic.create(
            title = "medium",
            accountID = "",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            regGameResults = mutableListOf()
        ),
        RegStatistic.create(
            title = "hard",
            accountID = "",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            regGameResults = mutableListOf()
        )
    )
    fun getAllRegStatistics(): List<RegStatistic> {
        return allRegStatistics
    }
}