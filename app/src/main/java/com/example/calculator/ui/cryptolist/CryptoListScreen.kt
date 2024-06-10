package com.example.calculator.ui.cryptolist

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    CryptoListScreenContent(uiState = uiState)
}

@Composable
private fun CryptoListScreenContent(
    uiState: CoinListScreenState,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                // Show loading
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Loading..."
                )
            }

            uiState.error.isNotEmpty() -> {
                // Show error
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = uiState.error
                )
            }

            else -> {
                // Show list
                CoinsList(dataList = uiState.dataList)
            }
        }
    }
}

@Composable
fun CoinsList(dataList: List<CoinListUiModel>) {
    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, top = 64.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(dataList) {
            CoinItem(model = it)
        }
    }
}

@Composable
fun CoinItem(
    modifier: Modifier = Modifier,
    onClick: (CoinListUiModel) -> Unit = {},
    model: CoinListUiModel,
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
            Text(text = model.name)
        }
    }
}

@Preview
@Composable
fun CryptoListScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CryptoListScreenContent(CoinListScreenState())
    }
}