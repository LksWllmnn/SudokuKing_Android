package com.example.sudokuking.data.database

import com.example.sudokuking.domain.model.Statistic

fun statisticToDb(statistic: Statistic): StatisticDb = StatisticDb(
    title = statistic.title,
    resolved = statistic.resolved,
    unresolved = statistic.unresolved,
    average = statistic.average,
    best = statistic.best
)

fun statisticFromDb(statistic: StatisticDb): Statistic? {
    return Statistic.create(
        title = statistic.title,
        resolved = statistic.resolved,
        unresolved = statistic.unresolved,
        average = statistic.average,
        best = statistic.best
    )
}