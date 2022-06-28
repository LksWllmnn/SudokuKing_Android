package com.example.sudokuking.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sudokuking.domain.model.RankTitle
import java.time.ZonedDateTime

@Entity(tableName = "account")
data class AccountDb (
    @PrimaryKey
    val id: String,
    val username: String,
    val password: String,
    val created: ZonedDateTime,
    val deleted: ZonedDateTime,
    val rankTitle: RankTitle,
    val progress: Int,
    val lineRank: Int
)