package com.example.calculator.ui.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.common.buildTestTag
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.operatorButtonColor
import com.example.calculator.ui.theme.resultBackgroundColor

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = hiltViewModel(),
) {

    val uiState by viewModel.uiState.collectAsState()

    CalculatorScreenContent(
        uiState = uiState,
        onNumberClick = viewModel::onNumberClick,
        onOperatorClick = viewModel::onOperatorClick,
        onClearClick = viewModel::onClearClick,
        onDotClick = viewModel::onDotClick,
    )
}

@Composable
private fun CalculatorScreenContent(
    uiState: CalculatorScreenUiState,
    onNumberClick: (Int) -> Unit = {},
    onOperatorClick: (CalculatorOperator) -> Unit = {},
    onDotClick: () -> Unit = {},
    onClearClick: () -> Unit = {},
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(.2.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = resultBackgroundColor)
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .buildTestTag("result_container")
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .buildTestTag("result_text_view"),
                    text = uiState.result,
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp,
                    textAlign = TextAlign.End,
                    color = Color.White,
                    lineHeight = 76.sp,
                )
            }
            CalculatorRow {
                CalculatorButton(
                    text = "AC",
                    testTag = "clear_button",
                    onClick = onClearClick,
                )
                CalculatorButton(
                    text = "+/-",
                    testTag = "plus_minus_button",
                    onClick = { onOperatorClick(CalculatorOperator.PlusMinus) }
                )
                CalculatorButton(
                    text = "%",
                    testTag = "percent_button",
                    onClick = { onOperatorClick(CalculatorOperator.Percent) }
                )
                CalculatorButton(
                    text = "÷",
                    testTag = "divide_button",
                    backgroundColor = operatorButtonColor,
                    onClick = { onOperatorClick(CalculatorOperator.Divide) }
                )
            }
            CalculatorRow {
                CalculatorButton(
                    text = "7",
                    testTag = "seven_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(7) },
                )
                CalculatorButton(
                    text = "8",
                    testTag = "eight_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(8) },
                )
                CalculatorButton(
                    text = "9",
                    testTag = "nine_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(9) },
                )
                CalculatorButton(
                    text = "*",
                    testTag = "multiply_button",
                    backgroundColor = operatorButtonColor,
                    onClick = { onOperatorClick(CalculatorOperator.Multiply) }
                )
            }
            CalculatorRow {
                CalculatorButton(
                    text = "4",
                    testTag = "four_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(4) },
                )
                CalculatorButton(
                    text = "5",
                    testTag = "five_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(5) },
                )
                CalculatorButton(
                    text = "6",
                    testTag = "six_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(6) },
                )
                CalculatorButton(
                    text = "-",
                    testTag = "minus_button",
                    backgroundColor = operatorButtonColor,
                    onClick = { onOperatorClick(CalculatorOperator.Minus) }
                )
            }
            CalculatorRow {
                CalculatorButton(
                    text = "1",
                    testTag = "one_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(1) },
                )
                CalculatorButton(
                    text = "2",
                    testTag = "two_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(2) },
                )
                CalculatorButton(
                    text = "3",
                    testTag = "three_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(3) },
                )
                CalculatorButton(
                    text = "+",
                    testTag = "plus_button",
                    backgroundColor = operatorButtonColor,
                    onClick = { onOperatorClick(CalculatorOperator.Plus) }
                )
            }
            CalculatorRow {
                CalculatorButton(
                    weight = 2f,
                    text = "0",
                    testTag = "zero_button",
                    backgroundColor = Color.Gray,
                    onClick = { onNumberClick(0) },
                )
                CalculatorButton(
                    text = ".",
                    testTag = "dot_button",
                    backgroundColor = Color.Gray,
                    onClick = onDotClick,
                )
                CalculatorButton(
                    text = "=",
                    testTag = "equals_button",
                    backgroundColor = operatorButtonColor,
                    onClick = { onOperatorClick(CalculatorOperator.Equals) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.CalculatorButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.DarkGray,
    weight: Float = 1f,
    fontSize: TextUnit = 24.sp,
    text: String,
    testTag: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .weight(weight)
            .buildTestTag(testTag),
        shape = RoundedCornerShape(0.dp),
        contentPadding = PaddingValues(vertical = 32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
        ),
        onClick = onClick,
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
        )
    }
}

@Composable
private fun CalculatorRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(.2.dp)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorTheme {
        CalculatorScreenContent(
            uiState = CalculatorScreenUiState(),
        )
    }
}
