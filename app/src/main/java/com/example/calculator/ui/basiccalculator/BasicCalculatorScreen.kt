package com.example.calculator.ui.basiccalculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.common.buildTestTag
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun BasicCalculatorScreen(
    viewModel: BasicCalculatorViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    BasicCalculatorScreenContent(
        uiState = uiState,
        onFirstNumberValueChange = viewModel::onFirstNumberValueChange,
        onSecondNumberValueChange = viewModel::onSecondNumberValueChange,
        onPlusClick = viewModel::onPlusClick,
        onBackClick = onBackClick,
    )
}

@Composable
fun BasicCalculatorScreenContent(
    uiState: BasicCalculatorScreenUiState,
    onFirstNumberValueChange: (String) -> Unit = {},
    onSecondNumberValueChange: (String) -> Unit = {},
    onPlusClick: () -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 128.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            modifier = Modifier.buildTestTag("back_button"),
            onClick = onBackClick
        ) {
            Text(modifier = Modifier.buildTestTag("back_text"), text = "Back")
        }
        Spacer(modifier = Modifier.size(64.dp))
        TextField(
            modifier = Modifier.buildTestTag("first_number_field"),
            placeholder = { Text(text = "First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = uiState.firstNumber,
            onValueChange = onFirstNumberValueChange
        )
        Spacer(modifier = Modifier.size(32.dp))
        TextField(
            modifier = Modifier.buildTestTag("second_number_field"),
            placeholder = { Text(text = "Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = uiState.secondNumber,
            onValueChange = onSecondNumberValueChange,
        )
        Spacer(modifier = Modifier.size(64.dp))
        Button(
            modifier = Modifier.buildTestTag("plus_button"),
            onClick = onPlusClick,
        ) {
            Text(modifier = Modifier.buildTestTag("plus_text"), text = "Plus")
        }
        Spacer(modifier = Modifier.size(32.dp))
        Text(
            modifier = Modifier.buildTestTag("result_text"),
            text = "Result: ${uiState.result}"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BasicCalculatorScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        BasicCalculatorScreenContent(
            uiState = BasicCalculatorScreenUiState(
                firstNumber = "1",
                secondNumber = "2",
                result = "3"
            )
        )
    }
}