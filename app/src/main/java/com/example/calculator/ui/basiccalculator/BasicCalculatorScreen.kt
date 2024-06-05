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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun BasicCalculatorScreen() {
    BasicCalculatorScreenContent()
}

@Composable
fun BasicCalculatorScreenContent() {
    // TODO: Practice2 - Do state hoisting (move the state to the ViewModel)
    var firstNumber by remember { mutableStateOf("") }
    var secondNumber by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp, top = 128.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            placeholder = { Text(text = "First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = firstNumber,
            onValueChange = {
                firstNumber = it
            }
        )
        Spacer(modifier = Modifier.size(32.dp))
        TextField(
            placeholder = { Text(text = "Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = secondNumber,
            onValueChange = {
                secondNumber = it
            },
        )
        Spacer(modifier = Modifier.size(64.dp))
        Button(onClick = {
            result = (firstNumber.toInt() + secondNumber.toInt()).toString()
        }) {
            Text(text = "Plus")
        }
        Spacer(modifier = Modifier.size(32.dp))
        Text(text = "Result: $result")
    }
}

@Preview(showBackground = true)
@Composable
fun BasicCalculatorScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        BasicCalculatorScreenContent()
    }
}