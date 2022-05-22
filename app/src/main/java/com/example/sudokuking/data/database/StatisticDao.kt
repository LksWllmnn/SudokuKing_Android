package com.example.sudokuking.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StatisticDao {
    @Insert
    suspend fun insert(statistic: StatisticDb)

    @Query("SELECT * FROM statistic")
    suspend fun getAll(): List<StatisticDb>

    @Query("SELECT * FROM statistic")
    fun observeAll(): Flow<List<StatisticDb>>

    @Query("DELETE FROM statistic")
    suspend fun deleteAll()
}