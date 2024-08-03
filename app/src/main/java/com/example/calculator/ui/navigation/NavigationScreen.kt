package com.example.calculator.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.common.buildTestTag
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun NavigationScreen(
    onBasicCalculatorClick: () -> Unit = {},
    onCalculatorClick: () -> Unit = {},
    onCounterClick: () -> Unit,
    onCryptoListClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    NavigationScreenContent(
        onBasicCalculatorClick = onBasicCalculatorClick,
        onCalculatorClick = onCalculatorClick,
        onCounterClick = onCounterClick,
        onCryptoListClick = onCryptoListClick,
        onMenuClick = onMenuClick
    )
}

@Composable
fun NavigationScreenContent(
    onBasicCalculatorClick: () -> Unit = {},
    onCalculatorClick: () -> Unit = {},
    onCounterClick: () -> Unit = {},
    onCryptoListClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 48.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Toolbox",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )
        NavigationButton(
            modifier = Modifier.buildTestTag("basic_calculator"),
            text = "Basic Calculator",
            onClick = onBasicCalculatorClick
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("calculator"),
            text = "Calculator",
            onClick = onCalculatorClick,
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("counter"),
            text = "Counter",
            onClick = onCounterClick,
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButton(
            modifier = Modifier.buildTestTag("crypto_list"),
            text = "Crypto Currency",
            onClick = onCryptoListClick
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Menu",
            onClick = onMenuClick
        )
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "Test Automation Exercise",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "https://github.com/NoushinB",
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

        )
    }
}


@Composable
fun NavigationButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun NavigationScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        NavigationScreenContent()
    }
}