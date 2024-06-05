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
            val validFirstNumber = if (_uiState.value.firstNumber == "0") "" else {
                _uiState.value.firstNumber
            }
            val newNumber = validFirstNumber + number
            _uiState.update { it.copy(firstNumber = newNumber, result = newNumber) }
        } else {
            val validSecondNumber = if (_uiState.value.secondNumber == "0") "" else {
                _uiState.value.secondNumber
            }
            val newNumber = validSecondNumber + number
            _uiState.update {
                it.copy(
                    secondNumber = newNumber,
                    result = newNumber,
                )
            }
        }
    }

    fun onOperatorClick(operator: CalculatorOperator) {
        if (operator is CalculatorOperator.Equals) {
            calculateResult()
        } else if (operator is CalculatorOperator.PlusMinus) {
            setPlusMinus()
        } else {
            if (_uiState.value.firstNumber.isNotEmpty()) {
                _uiState.update { it.copy(operator = operator) }
            }
        }
    }

    fun onDotClick() {
        if (_uiState.value.operator == null) {
            if (!_uiState.value.firstNumber.contains(".")) {
                val validFirstNumber = if (_uiState.value.firstNumber == "") "0" else {
                    _uiState.value.firstNumber
                }
                val newNumber = "$validFirstNumber."
                _uiState.update { it.copy(firstNumber = newNumber, result = newNumber) }
            }
        } else {
            if (!_uiState.value.secondNumber.contains(".")) {
                val validSecondNumber = if (_uiState.value.secondNumber == "") "0" else {
                    _uiState.value.secondNumber
                }
                val newNumber = "$validSecondNumber."
                _uiState.update {
                    it.copy(secondNumber = newNumber, result = newNumber)
                }
            }
        }
    }

    private fun calculateResult() {
        with(_uiState.value) {
            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && operator != null) {
                val decimalFirstNumber = firstNumber.toBigDecimal()
                val decimalSecondNumber = secondNumber.toBigDecimal()

                val result = when (operator) {
                    is CalculatorOperator.Plus -> decimalFirstNumber + decimalSecondNumber
                    is CalculatorOperator.Minus -> decimalFirstNumber - decimalSecondNumber
                    is CalculatorOperator.Percent -> decimalFirstNumber % decimalSecondNumber
                    is CalculatorOperator.Multiply -> decimalFirstNumber * decimalSecondNumber
                    is CalculatorOperator.Divide -> decimalFirstNumber / decimalSecondNumber
                    else -> this.result.toBigDecimal()
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

    private fun setPlusMinus() {
        val number = if (_uiState.value.operator == null) {
            _uiState.value.firstNumber
        } else {
            _uiState.value.secondNumber
        }

        val newNumber = if (number.isNotEmpty() && number != "0" && number.first() != '-') {
            "-$number"
        } else if (number.isNotEmpty() && number.first() == '-') {
            number.substring(1)
        } else {
            number
        }

        if (_uiState.value.operator == null) {
            _uiState.update { it.copy(firstNumber = newNumber, result = newNumber) }
        } else {
            _uiState.update { it.copy(secondNumber = newNumber, result = newNumber) }
        }
    }
}