package com.example.sudokuking.domain.model

class RegGameResult (
    val id: String,
    val accId: String,
    val solved: Boolean,
    val time: Long,
    val difficulty: String,
    val sudokuFileLineNumber: Int,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegGameResult

        if (id != other.id) return false
        if (accId != other.accId) return false
        if (solved != other.solved) return false
        if (time != other.time) return false
        if (difficulty != other.difficulty) return false
        if (sudokuFileLineNumber != other.sudokuFileLineNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + accId.hashCode()
        result = 31 * result + solved.hashCode()
        result = 31 * result + time.hashCode()
        result = 31 * result + difficulty.hashCode()
        result = 31 * result + sudokuFileLineNumber
        return result
    }

    companion object {
        fun create(
            id: String,
            accId: String,
            solved: Boolean,
            time: Long,
            difficulty: String,
            sudokuFileLineNumber: Int,
        ): RegGameResult {
            return RegGameResult(id, accId, solved, time, difficulty, sudokuFileLineNumber)
        }
    }
}