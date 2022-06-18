package com.example.sudokuking.domain.model


class Statistic private constructor(
    val title: String,
    var resolved: Int,
    var unresolved: Int,
    var average: Long,
    var best: Long,
    var amount: Int,
    val gameResults: MutableList<GameResult>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Statistic

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + resolved
        result = 31 * result + unresolved
        result = 31 * result + average.hashCode()
        result = 31 * result + best.hashCode()
        result = 31 * result + amount.hashCode()
        return result
    }

    companion object {
        fun create(
            title: String,
            resolved: Int,
            unresolved: Int,
            average: Long,
            best: Long,
            amount: Int,
            gameResults: MutableList<GameResult>
        ): Statistic {
            return Statistic(title, resolved, unresolved, average, best, amount, gameResults)
        }
    }
}