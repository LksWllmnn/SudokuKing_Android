package com.example.sudokuking.domain

import com.example.sudokuking.data.SudokuRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ObserveSudokuUseCase @Inject constructor(
    private val sudokuRepository: SudokuRepository
) {
    operator fun invoke() = sudokuRepository.observeSudoku().flowOn(Dispatchers.Default)
}