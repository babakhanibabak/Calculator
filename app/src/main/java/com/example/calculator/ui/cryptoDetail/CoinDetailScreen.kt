package com.example.calculator.ui.cryptoDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CoinDetailScreenContent(uiState = uiState)
}

@Composable
private fun CoinDetailScreenContent(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            uiState.error.isNotEmpty() -> {}
            else -> {
                CoinDetail(uiState = uiState)
            }
        }
    }
}


@Composable
fun CoinDetail(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
) {
    Scaffold(
        topBar = { MyAppBar(title = "Coin Detail") },
        content = { padding ->
            Surface(modifier = modifier.padding(padding)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    uiState.showDetailData?.let { data ->
                        // TODO: Design
                        Text(
                            text = data.message.orEmpty(),
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = data.description.orEmpty(),
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = data.firstPrice.toString())

                        Spacer(modifier = Modifier.size(10.dp))
                        Text(text = data.lastPrice.toString())
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun CoinDetailScreenPreview() {
    CalculatorTheme {
        CoinDetailScreenContent(
            uiState = CoinDetailScreenState(
                showDetailData = CoinDetailUiModel(
                    message = "Detail",
                    description = "Description",
                    firstPrice = 20,
                    lastPrice = 50,
                )
            ),
        )
    }
}