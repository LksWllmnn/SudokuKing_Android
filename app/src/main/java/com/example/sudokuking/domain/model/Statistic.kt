package com.example.sudokuking.domain.model


class Statistic private constructor(
    val title: String,
    val resolved: Int,
    val unresolved: Int,
    val average: Float,
    val best: Float
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Statistic

        if (title != other.title) return false

        return true
    }

    companion object {
        fun create(
            title: String,
            resolved: Int,
            unresolved: Int,
            average: Float,
            best: Float
        ): Statistic {
            return Statistic(title, resolved, unresolved, average, best)
        }
    }
}