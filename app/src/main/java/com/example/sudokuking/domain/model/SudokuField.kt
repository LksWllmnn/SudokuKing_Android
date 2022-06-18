package com.example.sudokuking.domain.model

class SudokuField private constructor(
    var isSelected: Boolean,
    val index: Int,
    val notes: List<Int>?,
    var number: String,
    var isFixed: Boolean
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SudokuField
        return true
    }

    override fun hashCode(): Int {
        var result = isSelected.hashCode()
        result = 31 * result + index
        result = 31 * result + (notes?.hashCode() ?: 0)
        result = 31 * result + number.hashCode()
        result = 31 * result + isFixed.hashCode()
        return result
    }

    companion object {
        fun create(
            isSelected: Boolean,
            index: Int,
            notes: List<Int>?,
            number: String,
            isFixed: Boolean
        ): SudokuField {
            return SudokuField(isSelected, index, notes, number, isFixed)
        }
    }
}