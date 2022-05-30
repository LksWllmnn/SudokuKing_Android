package com.example.sudokuking.data

import com.example.sudokuking.App
import com.example.sudokuking.data.database.StatisticDao
import com.example.sudokuking.data.database.statisticFromDb
import com.example.sudokuking.data.database.statisticToDb
import com.example.sudokuking.domain.model.Statistic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.map

val statisticRepo = StatisticRepository(App.database.statisticDao())

class StatisticRepository @Inject constructor(
    private val dao: StatisticDao,
) {

    suspend fun getAllStatistics(): List<Statistic> = dao.getAll().map{ statisticFromDb(it) }

    fun observeAllStatistics(): Flow<List<Statistic>> = dao.observeAll().map { it.mapNotNull(::statisticFromDb) }

    suspend fun addStatistic(statistic: Statistic) {
        dao.insert(
            statisticToDb(statistic)
        )
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}