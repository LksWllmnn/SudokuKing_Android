package com.example.sudokuking.data

import androidx.compose.ui.res.stringResource
import com.example.sudokuking.R
import com.example.sudokuking.data.database.StatisticDao
import com.example.sudokuking.data.database.statisticFromDb
import com.example.sudokuking.data.database.statisticToDb
import com.example.sudokuking.domain.model.Statistic
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.map

val statisticRepo = StatisticRepository()

class StatisticRepository @Inject constructor() {
    private val allStatistics = listOf(
        Statistic.create("Easy",45,55,13.5f,5.5f),
        Statistic.create("Medium",35,65,14.5f,6.5f),
        Statistic.create("Hard",25,75,15.5f,7.5f)
    ).filterNotNull()

    suspend fun getAllStatistics() = allStatistics
}

/*class StatisticRepository @Inject constructor(
    private val dao: StatisticDao
) {
    suspend fun getAllStatistics(): List<Statistic> = dao.getAll().mapNotNull { statisticFromDb(it) }

    fun observeAllStatistics(): Flow<List<Statistic>> = dao.observeAll().map { it.mapNotNull(::statisticFromDb) }

    suspend fun addStatistic(statistic: Statistic) {
        dao.insert(
            statisticToDb(statistic)
        )
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}*/