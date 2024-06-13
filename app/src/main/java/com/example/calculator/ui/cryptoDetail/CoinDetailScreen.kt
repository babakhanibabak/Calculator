package com.example.calculator.ui.cryptoDetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel= hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    CoinDetailScreenContent(uiState = uiState)
}

@Composable
fun CoinDetailScreenContent(modifier: Modifier = Modifier,
                            uiState: CoinDetailScreenState
                            ) {

}