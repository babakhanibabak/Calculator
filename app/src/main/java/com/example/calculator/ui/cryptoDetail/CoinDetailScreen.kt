package com.example.calculator.ui.cryptoDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.domain.model.CoinDetailModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    CoinDetailScreenContent(uiState = uiState, model = CoinDetailUiModel())
}

@Composable
private fun CoinDetailScreenContent(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
    model: CoinDetailUiModel
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
                CoinDetail(uiState = uiState, model = model)
            }
        }
    }
}


@Composable
fun CoinDetail(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
    model: CoinDetailUiModel
) {
    Scaffold(
        topBar = { AddAppBar() },
        content = { padding ->
            Surface(modifier = modifier.padding(padding)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    uiState.showDetailData?.let { data ->
                        // TODO: Design detail screen here to show detail data

                        Text(
                            text = "this is Bitcoin crypto currency",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = "Bitcoin is now first crypto currency",
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        model.firstPrice

                        Spacer(modifier = Modifier.size(10.dp))
                        model.lastPrice

                    }
                }
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Crypto Detail",
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
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
            model = CoinDetailUiModel()
        )
    }
}