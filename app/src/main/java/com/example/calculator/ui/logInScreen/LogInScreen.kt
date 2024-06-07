package com.example.calculator.ui.logInScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun LogInScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            colors =ButtonDefaults.buttonColors(Color.Green)
        ) {
            Text(text = "BasicCalculatorScreen")
        }
        Spacer(modifier = Modifier.size(50.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(text = "CalculatorScreen")
        }
    }
}

@Preview
@Composable
private fun LogInScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        LogInScreen(
            modifier = modifier,
        )
    }
}