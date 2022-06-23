package com.example.sudokuking.data.database

import com.example.sudokuking.domain.model.Account

fun accountToDb(account: Account): AccountDb = AccountDb(
    id = account.id,
    username = account.username,
    password = account.password,
    created = account.created,
    deleted = account.deleted

)

fun accountFromDb(account: AccountDb): Account = Account.create(
    id = account.id,
    username = account.username,
    password = account.password
)