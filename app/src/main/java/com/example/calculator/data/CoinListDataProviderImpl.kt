package com.example.calculator.data

import com.example.calculator.R
import com.example.calculator.domain.CoinListDataProvider
import com.example.calculator.domain.CoinListItemModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinListDataProviderImpl @Inject constructor() : CoinListDataProvider {
    override suspend fun getCoinsList(): List<CoinListItemModel> {
        delay(3000)
        return listOf(
            CoinListItemModel("1", "Bitcoin", "BTC", 1, photo = R.drawable.bit),
            CoinListItemModel("2", "tether", "tet", 1, photo = R.drawable.tether),
            CoinListItemModel("3", "ethereum", "eth", 1, photo = R.drawable.ethereum),
            CoinListItemModel("4", "usdc", "usd", 1, photo = R.drawable.usdc),
        )
    }
}