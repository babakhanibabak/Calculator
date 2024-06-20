package com.example.calculator.data.datasource.local

import com.example.calculator.R
import com.example.calculator.data.model.CoinDetailData
import com.example.calculator.domain.model.CoinListItemModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class CoinDataProvider @Inject constructor() {

    suspend fun getCoinsList(): List<CoinListItemModel> {
        delay(1000)
        return coinList
    }

    suspend fun getCoinDetail(coinId: String): CoinDetailData {
        delay(1000)
        val coin = coinList.find { it.id == coinId }
        return CoinDetailData(
            message = coin?.message.orEmpty(),
            description = coin?.description.orEmpty(),
            firstPrice = coin?.firstPrice ?: 0,
            lastPrice = coin?.lastPrice ?: 0,
            photo = coin?.photo ?:0

        )
    }

    private val coinList = listOf(
        CoinListItemModel(
            id = "1",
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1,
            photo = R.drawable.bit,
            message = "Bitcoin Message",
            description = "Bitcoin Description",
            firstPrice = 10,
            lastPrice = 64000,
        ),
        CoinListItemModel(
            id = "2",
            name = "Tether",
            symbol = "tet",
            rank = 2,
            photo = R.drawable.tether,
            message = "Tether Message",
            description = "Tether Description",
            firstPrice = 10,
            lastPrice = 3000,
        ),
        CoinListItemModel(
            id = "3",
            name = "Ethereum",
            symbol = "eth",
            rank = 3,
            photo = R.drawable.ethereum,
            message = "Ethereum Message",
            description = "Ethereum Description"
        ),
        CoinListItemModel(
            id = "4",
            name = "USDC",
            symbol = "usdc",
            rank = 4,
            photo = R.drawable.usdc,
            message = "USDT Message",
            description = "USDT Description"
        ),
    )
}