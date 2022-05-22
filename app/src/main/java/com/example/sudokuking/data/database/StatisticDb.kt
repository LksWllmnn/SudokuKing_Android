package com.example.sudokuking.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistic")
class StatisticDb (
    @PrimaryKey
    val title: String,
    val resolved: Int,
    val unresolved: Int,
    val average: Float,
    val best: Float
)