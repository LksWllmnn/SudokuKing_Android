package com.example.sudokuking

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.sudokuking.data.database.AppDatabase
import com.example.sudokuking.data.gameResultRepo
import com.example.sudokuking.data.statisticRepo
import com.example.sudokuking.domain.ComputeGameResultsUseCase
import com.example.sudokuking.domain.ComputeRegGameResultsUseCase
import com.example.sudokuking.domain.InitialiseGameResultsUseCase
import kotlinx.coroutines.runBlocking


class App : Application() {
    private val userSettingsStore: DataStore<Preferences> by preferencesDataStore(name = "userSettings")

    override fun onCreate() {
        super.onCreate()
        userSettingsRepo = UserSettingsRepository(userSettingsStore)
        database = Room
            .databaseBuilder(this, AppDatabase::class.java, "app")
            .apply {
                if (BuildConfig.DEBUG) fallbackToDestructiveMigration()
            }
            .build()

        runBlocking {
            //database.statisticDao().deleteAll()
            //InitializeStatisticUseCase(statisticRepo)()
            //database.gameResultsDao().deleteAll()
            ComputeGameResultsUseCase()()
            ComputeRegGameResultsUseCase()()
        }
    }

    companion object {
        lateinit var userSettingsRepo: UserSettingsRepository
        lateinit var database: AppDatabase
    }
}