package com.example.calculator.ui.cryptoDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.domain.CoinDetailModel
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
    uiState: CoinDetailScreenState
) {
    Box(modifier = modifier.fillMaxSize()) {
        when {
            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            uiState.error.isNotEmpty() -> {}
            else ->  {
                CoinDetail(uiState = uiState,data =CoinDetailUiModel() )
            }
        }

    }
}


@Composable
fun CoinDetail(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
    data: CoinDetailUiModel,
    onClick: (CoinDetailUiModel) -> Unit = {}
) {
    Scaffold(
        topBar = { AddAppBar() },
        content = { padding ->
            Surface(modifier = modifier.padding(padding)) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    CoinDetail(
                        uiState = uiState,
                        data = CoinDetailUiModel(
                            message = "Detail",
                            description = "Description",
                            firstPrice = 20,
                            lastPrice = 50
                        )
                    )
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
        title = { Text(text = "Crypto Detail") },
        colors = TopAppBarDefaults.topAppBarColors(Color.Blue)
    )
}

@Preview
@Composable
private fun CoinDetailScreenPreview() {
    CalculatorTheme {
        CoinDetailScreenContent(uiState = CoinDetailScreenState())
    }
}