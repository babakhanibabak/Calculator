package com.example.calculator.ui.cryptolist

data class CoinListScreenState(
    val isLoading: Boolean = false,
    val dataList: List<CoinListUiModel> = emptyList(),
    val error: String = "",
)