package com.example.calculator.ui.cryptolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.R
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()

    CryptoListScreenContent(
        uiState = uiState,
        onItemClick = onItemClick,
        onBackClick = onBackClick,
    )
}

@Composable
private fun CryptoListScreenContent(
    uiState: CoinListScreenState,
    onItemClick: (String) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyAppBar(title = "Coins List") {
                onBackClick()
            }
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
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
                    CoinsList(dataList = uiState.dataList, onItemClick = onItemClick)
                }
            }
        }
    }
}


@Composable
fun CoinsList(
    dataList: List<CoinListUiModel>,
    onItemClick: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 32.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(dataList) {
            CoinItem(
                model = it,
                onClick = { model ->
                    onItemClick(model.id)
                }
            )
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
                width = 3.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(15.dp)
            )
            .clickable { onClick(model) }
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = model.photo),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier.weight(1f),
                text = model.name,
                fontSize = 30.sp,
            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(
                    modifier = Modifier,
                    text = model.symbol,
                    fontSize = 25.sp,
                )
                Text(
                    modifier = Modifier,
                    text = model.rank.toString(),
                    fontSize = 25.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun CryptoListScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CryptoListScreenContent(
            CoinListScreenState(
                dataList = listOf(
                    CoinListUiModel(
                        id = "1",
                        name = "Bitcoin",
                        symbol = "BTC",
                        photo = R.drawable.bit,
                        rank = 1,
                    )
                ),
            ),
            onItemClick = {},
            onBackClick = {},
        )
    }
}