package com.example.calculator.domain.repository

import com.example.calculator.domain.model.CoinDetailModel
import com.example.calculator.domain.model.CoinListItemModel

interface CoinRepository {
    suspend fun getCoinsList(): List<CoinListItemModel>

    suspend fun getCoinDetail(coinId: String): CoinDetailModel
}