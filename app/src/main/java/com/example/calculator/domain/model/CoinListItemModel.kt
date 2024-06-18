package com.example.calculator.domain.model

data class CoinListItemModel(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val photo: Int,
    val message: String,
    val description: String,
    val firstPrice: Int = 0,
    val lastPrice: Int = 0,
)