package com.example.sudokuking.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    version = 3,
    entities = [
        //StatisticDb::class
        GameResultDb::class,
        AccountDb::class,
        RegGameResultDB::class
    ],
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    //abstract fun statisticDao(): StatisticDao
    abstract fun gameResultsDao(): GameResultDao
    abstract fun accountDao(): AccountDao
    abstract fun regGameResultDao(): RegGameResultDao
}