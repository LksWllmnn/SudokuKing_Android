package com.example.sudokuking.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "regGameResult")
class RegGameResultDB (
    @PrimaryKey
    val id: String,
    val accountID: String,
    val solved: Boolean,
    val time: Long,
    val difficulty: String,
    val sudokuFileLineNumber: Int
)