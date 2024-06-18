package com.example.calculator.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.common.buildTestTag
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun NavigationScreen(
    onBasicCalculatorClick: () -> Unit = {},
    onCalculatorClick: () -> Unit = {},
    onCounterClick: () -> Unit,
    onCryptoListClick: () -> Unit = {},
) {
    NavigationScreenContent(
        onBasicCalculatorClick = onBasicCalculatorClick,
        onCalculatorClick = onCalculatorClick,
        onCounterClick = onCounterClick,
        onCryptoListClick= onCryptoListClick
    )
}

@Composable
fun NavigationScreenContent(
    onBasicCalculatorClick: () -> Unit = {},
    onCalculatorClick: () -> Unit = {},
    onCounterClick: () -> Unit = {},
    onCryptoListClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        NavigationButton(
            modifier = Modifier.buildTestTag("basic_calculator"),
            text = "Basic Calculator",
            color = Color.Green,
            onClick = onBasicCalculatorClick
        )
        Spacer(modifier = Modifier.size(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("calculator"),
            text = "Calculator",
            color = Color.Magenta,
            onClick = onCalculatorClick,
        )
        Spacer(modifier = Modifier.size(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("counter"),
            text = "Counter",
            color = Color.Red,
            onClick = onCounterClick,
        )
        Spacer(modifier = Modifier.size(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("crypto_list"),
            text = "Todo",
            color = Color.Yellow,
            onClick = onCryptoListClick)
    }
}


@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        )
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun NavigationScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        NavigationScreenContent()
    }
}