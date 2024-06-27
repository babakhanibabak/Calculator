package com.example.calculator.ui.cryptoDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.calculator.R
import com.example.calculator.ui.components.CircleImage
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {},

    ) {
    val uiState by viewModel.uiState.collectAsState()

    CoinDetailScreenContent(
        uiState = uiState, onBackClick = onBackClick
    )
}

@Composable
private fun CoinDetailScreenContent(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { MyAppBar(title = "Coin Detail") { onBackClick() } },
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
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
}


@Composable
fun CoinDetail(
    modifier: Modifier = Modifier,
    uiState: CoinDetailScreenState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 15.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        uiState.showDetailData?.let { data ->
            // TODO: Design
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                data.photo?.let {
                    CircleImage(
                        modifier = Modifier,
                        imageId = it
                    )
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Detail",
                    fontSize = 20.sp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = data.message.orEmpty(),
                    fontSize = 20.sp,
                    color = Color.Blue,
                    textAlign = TextAlign.Left
                )
            }
            HorizontalDivider(color = Color.LightGray)
            Spacer(modifier = Modifier.size(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Description",
                    fontSize = 20.sp,
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = data.description.orEmpty(),
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 15.sp,
                    color = Color.Blue
                )
            }
            HorizontalDivider(color = Color.LightGray, thickness = 3.dp)
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "First Price",
                    fontSize = 20.sp,
                    color = Color.Gray)
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = "${data.firstPrice.toString()} $",
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Last Price" ,
                    fontSize = 20.sp,
                    color = Color.Gray)
                Spacer(modifier = Modifier.size(25.dp))
                Text(
                    text = "${data.lastPrice.toString()} $",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
private fun CoinDetailScreenPreview() {
    CalculatorTheme {
        CoinDetailScreenContent(
            uiState = CoinDetailScreenState(
                showDetailData = CoinDetailUiModel(
                    message = "Detail",
                    description = "Bitcoin is the world's first decentralized cryptocurrency." +
                            " A cryptocurrency is a digital asset that uses cryptography" +
                            " for security and operates independently of a central bank or authority.",
                    firstPrice = 20,
                    lastPrice = 50,
                    photo = R.drawable.bit
                )
            ),
            onBackClick = {}

        )
    }
}