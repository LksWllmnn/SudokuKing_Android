package com.example.sudokuking

import android.app.Application
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.example.sudokuking.data.database.AppDatabase
import com.example.sudokuking.data.network.WebService
import com.example.sudokuking.data.statisticRepo
import com.example.sudokuking.domain.InitializeStatisticUseCase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


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
            database.statisticDao().deleteAll()
            InitializeStatisticUseCase(statisticRepo)()
        }
    }

    companion object {
        lateinit var userSettingsRepo: UserSettingsRepository
        lateinit var database: AppDatabase
    }
}