package com.example.sudokuking.domain.model

class GameResult private constructor(
    val id: String,
    val solved: Boolean,
    val time: Long,
    val difficulty: String,
    val sudokuFileLineNumber: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameResult

        if (solved != other.solved) return false
        if (time != other.time) return false
        if (difficulty != other.difficulty) return false
        if (sudokuFileLineNumber != other.sudokuFileLineNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = solved.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + difficulty.hashCode()
        result = 31 * result + sudokuFileLineNumber
        return result
    }

    companion object {
        fun create(
            id: String,
            solved: Boolean,
            time: Long,
            difficulty: String,
            sudokuFileLineNumber: Int
        ): GameResult {
            return GameResult(id, solved,time,difficulty,sudokuFileLineNumber)
        }
    }
}