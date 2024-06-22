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
            photo = coin?.photo ?: 0

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
            description = "Bitcoin is the world's first decentralized cryptocurrency." +
                    " A cryptocurrency is a digital asset that uses cryptography" +
                    " for security and operates independently of a central bank or authority.",
            firstPrice = 520,
            lastPrice = 64000,
        ),
        CoinListItemModel(
            id = "2",
            name = "Tether",
            symbol = "TET",
            rank = 2,
            photo = R.drawable.tether,
            message = "Tether Message",
            description = "Tether, often abbreviated as USDT or USD₮ " +
                    "is a type of cryptocurrency known as a stablecoin." +
                    " Unlike traditional cryptocurrencies like Bitcoin," +
                    " which can experience significant price swings, "
            ,
            firstPrice = 410,
            lastPrice = 3000,
        ),
        CoinListItemModel(
            id = "3",
            name = "Ethereum",
            symbol = "ETH",
            rank = 3,
            photo = R.drawable.ethereum,
            message = "Ethereum Message",
            description = "Ethereum is a revolutionary blockchain platform " +
                    "  that goes beyond just being a cryptocurrency.",
            firstPrice = 250,
            lastPrice = 2400
        ),
        CoinListItemModel(
            id = "4",
            name = "usdc",
            symbol = "USDC",
            rank = 4,
            photo = R.drawable.usdc,
            message = "USDT Message",
            description = "USD Coin (USDC) is another type of cryptocurrency known as a stablecoin." +
                    " Similar to Tether (USDT), USDC aims to maintain a stable value by being pegged " +
                    "to the US dollar (USD).Ideally, 1 USDC should always be worth close to \$1 USD. ",
            firstPrice = 310,
            lastPrice = 4200
        ),
    )
}