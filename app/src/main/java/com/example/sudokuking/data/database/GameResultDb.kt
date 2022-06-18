package com.example.sudokuking.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gameResult")
data class GameResultDb (
    @PrimaryKey
    val id: String,
    val solved: Boolean,
    val time: Long,
    val difficulty: String,
    val sudokuFileLineNumber: Int
)