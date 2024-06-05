package com.example.calculator.ui.calculator

import android.icu.math.BigDecimal

data class CalculatorScreenUiState(
    val result: String = "0",
    val firstNumber: String = "",
    val secondNumber: String = "",
    val operator: CalculatorOperator? = null,
)

sealed interface CalculatorOperator {
    data object Plus : CalculatorOperator // +
    data object Minus : CalculatorOperator // -
    data object PlusMinus:CalculatorOperator // +-
    data object Percent : CalculatorOperator // %
    data object Divide : CalculatorOperator // /
    data object Multiply : CalculatorOperator // *
    data object Equals : CalculatorOperator // =
    data object Decimal : CalculatorOperator // .
}
