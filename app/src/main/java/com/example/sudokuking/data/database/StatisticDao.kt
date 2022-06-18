package com.example.sudokuking.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//@Dao
//abstract class StatisticDao {
//    @Insert
//    abstract suspend fun insert(statistic: StatisticDb)
//
//    @Query("SELECT * FROM statistic")
//    abstract suspend fun getAll(): List<StatisticDb>
//
//    @Query("SELECT * FROM statistic")
//    abstract fun observeAll(): Flow<List<StatisticDb>>
//
//    @Query("DELETE FROM statistic")
//    abstract suspend fun deleteAll()
//
//}