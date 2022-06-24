package com.example.sudokuking.data

import com.example.sudokuking.domain.model.RegStatistic
import javax.inject.Inject

val regStatisticRepo = RegStatisticRepository()

class RegStatisticRepository @Inject constructor() {
    private var allRegStatistics: RegStatistic =
        RegStatistic.create(
            accountID = "",
            resolved = 0,
            unresolved = 0,
            average = 0,
            best = 0,
            amount = 0,
            regGameResults = mutableListOf()
        )

    fun getAllRegStatistics(): RegStatistic {
        return allRegStatistics
    }
}