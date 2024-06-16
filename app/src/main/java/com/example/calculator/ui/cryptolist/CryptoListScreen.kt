package com.example.calculator.ui.cryptolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = hiltViewModel(),
    onItemClick: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()

    CryptoListScreenContent(uiState = uiState, onItemClick = onItemClick)
}

@Composable
private fun CryptoListScreenContent(
    uiState: CoinListScreenState,
    onItemClick: () -> Unit,
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
                CoinsList(dataList = uiState.dataList, onItemClick = onItemClick)
            }
        }
    }
}


@Composable
fun CoinsList(
    dataList: List<CoinListUiModel>,
    onItemClick: () -> Unit,
) {
    Scaffold(
        topBar = { AddAppBar() },
        content = { padding ->
            Surface(modifier = Modifier.padding(padding)) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 16.dp,
                        top = 64.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(dataList) {
                        CoinItem(
                            model = it,
                            onClick = {
                                onItemClick()
                            }
                        )
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(modifier: Modifier = Modifier) {
    TopAppBar(modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(Color.Magenta),
        title = {
            Text(modifier=Modifier.fillMaxWidth(),
                text = "Crypto List",
                textAlign = TextAlign.Center,
                fontSize = 35.sp
            )
        })
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
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(id = model.photo),
                contentDescription = "",
            )
            Text(text = model.name, modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = model.id, modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = model.symbol, modifier = Modifier.align(Alignment.CenterVertically))

        }
    }
}

@Preview
@Composable
fun CryptoListScreenPreview(modifier: Modifier = Modifier) {
    CalculatorTheme {
        CryptoListScreenContent(CoinListScreenState(), onItemClick = {})
    }
}