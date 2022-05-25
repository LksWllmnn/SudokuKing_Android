package com.example.sudokuking.domain.model

class SudokuField private constructor(
    val notes: List<Int>?,
    val number: Int
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SudokuField
        return true
    }

    companion object {
        fun create(
            notes: List<Int>?,
            number: Int
        ): SudokuField {
            return SudokuField(notes, number)
            //return SudokuField(number)
        }
    }
}