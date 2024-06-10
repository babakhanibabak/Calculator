package com.example.calculator.domain

interface CoinListDataProvider {
    suspend fun getCoinsList(): List<CoinListItemModel>
}