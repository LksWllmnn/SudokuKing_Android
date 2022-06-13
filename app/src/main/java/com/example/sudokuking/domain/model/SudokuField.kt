package com.example.sudokuking.domain.model

class SudokuField private constructor(
    var isSelected: Boolean,
    val index: Int,
    val notes: List<Int>?,
    var number: Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SudokuField
        return true
    }

    companion object {
        fun create(
            isSelected: Boolean,
            index: Int,
            notes: List<Int>?,
            number: Int
        ): SudokuField {
            return SudokuField(isSelected, index, notes, number)
        }
    }
}