package com.example.sudokuking

import android.app.Application
import androidx.room.Room
import com.example.sudokuking.data.database.AppDatabase
import com.example.sudokuking.domain.ComputeGameResultsUseCase
import com.example.sudokuking.domain.ComputeRegGameResultsUseCase
import kotlinx.coroutines.runBlocking


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(this, AppDatabase::class.java, "app")
            .apply {
                if (BuildConfig.DEBUG) fallbackToDestructiveMigration()
            }
            .build()

        runBlocking {
            //database.gameResultsDao().deleteAll()
            ComputeGameResultsUseCase()()
            ComputeRegGameResultsUseCase()()
        }
    }

    companion object {
        lateinit var database: AppDatabase
    }
}