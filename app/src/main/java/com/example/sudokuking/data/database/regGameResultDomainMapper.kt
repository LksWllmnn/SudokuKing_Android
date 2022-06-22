package com.example.sudokuking.data.database

import com.example.sudokuking.domain.model.RegGameResult

fun regGameResultToDb(regGameResult: RegGameResult): RegGameResultDB = RegGameResultDB(
    id = regGameResult.id,
    accountID = regGameResult.accId,
    solved = regGameResult.solved,
    time = regGameResult.time,
    difficulty = regGameResult.difficulty,
    sudokuFileLineNumber = regGameResult.sudokuFileLineNumber
)

fun regGameResultFromDb(regGameResult: RegGameResultDB): RegGameResult
{
    return RegGameResult.create(
        id = regGameResult.id,
        accId = regGameResult.accountID,
        solved = regGameResult.solved,
        time = regGameResult.time,
        difficulty = regGameResult.difficulty,
        sudokuFileLineNumber = regGameResult.sudokuFileLineNumber
    )
}