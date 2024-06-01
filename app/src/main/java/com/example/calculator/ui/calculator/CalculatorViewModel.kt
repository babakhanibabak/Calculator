package com.example.calculator.ui.calculator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(CalculatorScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onClearClick() {
        _uiState.value = CalculatorScreenUiState()
    }

    fun onNumberClick(number: Int) {
        if (_uiState.value.operator == null) {
            val newNumber = _uiState.value.firstNumber + number
            _uiState.update { it.copy(firstNumber = newNumber, result = newNumber) }
        } else {
            val newNumber = _uiState.value.secondNumber + number
            _uiState.update {
                it.copy(
                    secondNumber = newNumber,
                    result = newNumber,
                )
            }
        }
    }

    fun onOperatorClick(operator: CalculatorOperator) {
        if (operator !is CalculatorOperator.Equals) {
            if (_uiState.value.firstNumber.isNotEmpty()) {
                _uiState.update { it.copy(operator = operator) }
            }
        } else {
            calculateResult()
        }
    }

    private fun calculateResult() {
        with(_uiState.value) {
            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && operator != null) {
                val result = when (operator) {
                    is CalculatorOperator.Plus -> firstNumber.toInt() + secondNumber.toInt()
                    is CalculatorOperator.Minus -> firstNumber.toInt() - secondNumber.toInt()
                    is CalculatorOperator.Multiply -> firstNumber.toInt() * secondNumber.toInt()
                    is CalculatorOperator.Divide -> firstNumber.toInt() / secondNumber.toInt()
                    else -> this.result.toInt()
                }
                _uiState.update {
                    it.copy(
                        firstNumber = result.toString(),
                        secondNumber = "",
                        operator = null,
                        result = result.toString(),
                    )
                }
            }
        }
    }
}