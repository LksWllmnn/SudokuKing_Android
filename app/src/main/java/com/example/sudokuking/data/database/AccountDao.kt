package com.example.sudokuking.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao {
    @Insert
    abstract suspend fun insert(account: AccountDb)

    @Query("SELECT * FROM account")
    abstract suspend fun getAll(): List<AccountDb>

    @Query("SELECT * FROM account")
    abstract fun observeAll(): Flow<List<AccountDb>>

    @Query("DELETE FROM account")
    abstract suspend fun deleteAll()
}