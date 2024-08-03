package com.example.calculator.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun GmailScreen() {
    GmailScreenContent()
}

@Composable
fun GmailScreenContent(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize(),

        ) { padding ->
        Column(modifier = Modifier.padding(padding)) {

        }

    }
}



@Preview
@Composable
private fun GmailScreenPreview() {
    CalculatorTheme {
        GmailScreenContent(

        )
    }
}