package com.example.sudokuking.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao {
    @Insert
    abstract suspend fun insert(account: AccountDb)

    @Update
    abstract suspend fun update(account: AccountDb)

    @Query("SELECT * FROM account")
    abstract suspend fun getAll(): List<AccountDb>

    @Query("SELECT * FROM account")
    abstract fun observeAll(): Flow<List<AccountDb>>

    @Query("DELETE FROM account")
    abstract suspend fun deleteAll()

    @Delete
    abstract suspend fun delete(account: AccountDb)
}