package com.example.calculator.ui.cryptolist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
) {
    CryptoListScreenContent()
}

@Composable
private fun CryptoListScreenContent() {

}

@Preview
@Composable
fun CryptoListScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CryptoListScreenContent()
    }
}