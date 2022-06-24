package com.example.sudokuking.domain.model

class RegStatistic (
    val accountID: String,
    var resolved: Int,
    var unresolved: Int,
    var average: Long,
    var best: Long,
    var amount: Int,
    val regGameResults: MutableList<RegGameResult>
    )
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegStatistic

        if (accountID != other.accountID) return false
        if (resolved != other.resolved) return false
        if (unresolved != other.unresolved) return false
        if (average != other.average) return false
        if (best != other.best) return false
        if (amount != other.amount) return false
        if (regGameResults != other.regGameResults) return false

        return true
    }

    override fun hashCode(): Int {
        var result = accountID.hashCode()
        result = 31 * result + resolved
        result = 31 * result + unresolved
        result = 31 * result + average.hashCode()
        result = 31 * result + best.hashCode()
        result = 31 * result + amount
        result = 31 * result + regGameResults.hashCode()
        return result
    }

    companion object {
        fun create(
            accountID: String,
            resolved: Int,
            unresolved: Int,
            average: Long,
            best: Long,
            amount: Int,
            regGameResults: MutableList<RegGameResult>
        ): RegStatistic {
            return RegStatistic(accountID, resolved, unresolved, average, best, amount, regGameResults)
        }
    }
}