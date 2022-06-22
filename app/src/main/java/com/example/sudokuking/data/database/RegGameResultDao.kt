package com.example.sudokuking.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RegGameResultDao {
    @Insert
    abstract suspend fun insert(RegGameResult: RegGameResultDB)

    @Query("SELECT * FROM regGameResult")
    abstract suspend fun getAll(): List<RegGameResultDB>

    @Query("SELECT * FROM regGameResult")
    abstract fun observeAll(): Flow<List<RegGameResultDB>>

    @Query("DELETE FROM regGameResult")
    abstract suspend fun deleteAll()
}