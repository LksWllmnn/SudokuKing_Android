package com.example.sudokuking.domain.model

import java.time.ZonedDateTime

class Account private constructor(
    var id: String,
    var username: String,
    var password: String,
    val created: ZonedDateTime,
    val deleted: ZonedDateTime,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun create(
            id: String,
            username: String,
            password: String
        ): Account {
            val now = ZonedDateTime.now()
            return Account(id, username, password, now, now)
        }
    }
}