package com.example.calculator.ui.menu

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme


@Composable
fun DateScreen(modifier: Modifier = Modifier) {
    DateScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateScreenContent(modifier: Modifier = Modifier) {
    val datePickerState= rememberDatePickerState()
}

@Preview
@Composable
private fun DateScreenContentPreview() {
    CalculatorTheme {
        DateScreenContent()
    }

}