package com.example.sudokuking.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GameResultDao {
    @Insert
    abstract suspend fun insert(GameResult: GameResultDb)

    @Query("SELECT * FROM gameResult")
    abstract suspend fun getAll(): List<GameResultDb>

    @Query("SELECT * FROM gameResult")
    abstract fun observeAll(): Flow<List<GameResultDb>>

    @Query("DELETE FROM gameResult")
    abstract suspend fun deleteAll()
}