package com.example.sudokuking.data.database

import com.example.sudokuking.domain.model.GameResult

fun gameResultToDb(gameResult: GameResult): GameResultDb = GameResultDb(
    id = gameResult.id,
    solved = gameResult.solved,
    time = gameResult.time,
    difficulty = gameResult.difficulty,
    sudokuFileLineNumber = gameResult.sudokuFileLineNumber
)

fun gameResultFromDb(gameResult: GameResultDb): GameResult
{
    return GameResult.create(
        id = gameResult.id,
        solved = gameResult.solved,
        time = gameResult.time,
        difficulty = gameResult.difficulty,
        sudokuFileLineNumber = gameResult.sudokuFileLineNumber
    )
}