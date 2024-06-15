package com.example.calculator.data.datasource.local

import com.example.calculator.R
import com.example.calculator.data.model.CoinDetailData
import com.example.calculator.domain.model.CoinListItemModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinDataProvider @Inject constructor() {
    suspend fun getCoinsList(): List<CoinListItemModel> {
        delay(3000)
        return listOf(
            CoinListItemModel("1", "Bitcoin", "BTC", 1, photo = R.drawable.bit),
            CoinListItemModel("2", "tether", "tet", 1, photo = R.drawable.tether),
            CoinListItemModel("3", "ethereum", "eth", 1, photo = R.drawable.ethereum),
            CoinListItemModel("4", "usdc", "usd", 1, photo = R.drawable.usdc),
        )
    }

    suspend fun getCoinDetail(coinId: String): CoinDetailData {
        delay(2000)
        return CoinDetailData(
            message = "message",
            description = "description",
            firstPrice = 10,
            lastPrice = 20,
        )
    }
}