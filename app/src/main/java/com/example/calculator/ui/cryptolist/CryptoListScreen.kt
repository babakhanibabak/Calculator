package com.example.calculator.ui.cryptolist

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    CryptoListScreenContent(
    )
}

@Composable
private fun CryptoListScreenContent(
    modifier: Modifier = Modifier,
) {
Column(modifier=modifier) {
    CoinItem(model = CoinListModel(id = "1", name = "Bitcoin", symbol = "BTC", rank = 1,photo= R.drawable.bit))
    CoinItem(model = CoinListModel(id = "2", name = "tether", symbol = "tet", rank = 1,photo= R.drawable.tether))
    CoinItem(model = CoinListModel(id = "3", name = "ethereum", symbol = "eth", rank = 1,photo= R.drawable.ethereum))
    CoinItem(model = CoinListModel(id = "4", name = "usdc", symbol = "usd", rank = 1,photo= R.drawable.usdc))
}

}

@Composable
fun CoinItem(
    modifier: Modifier = Modifier,
    onClick: (CoinListModel) -> Unit = {},
    model:CoinListModel
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 5.dp,
                color = Color.Red,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick(model) }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

        }

    }
}

@Preview
@Composable
fun CryptoListScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CryptoListScreenContent(
        )
    }
}