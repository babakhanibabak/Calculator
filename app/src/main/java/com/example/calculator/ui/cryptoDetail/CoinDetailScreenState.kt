package com.example.calculator.ui.cryptoDetail

data class CoinDetailScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val showDetailData: CoinDetailUiModel? = null
)

