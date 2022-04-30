package com.example.sudokuking.domain.model

import java.time.ZonedDateTime

@JvmInline
value class AccountId(val value: String)

class Account private constructor(
    val id: AccountId,
    val username: String,
    val password: String,
    val created: ZonedDateTime,
    val updated: ZonedDateTime,
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
            id: AccountId,
            username: String,
            password: String

        ): Account? {
            if (username.isBlank()) return null
            if (password.isBlank()) return null
            val now = ZonedDateTime.now()
            return Account(id, username, password, now, now, now)
        }
    }
}