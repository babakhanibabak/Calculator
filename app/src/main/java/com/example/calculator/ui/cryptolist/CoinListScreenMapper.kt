package com.example.calculator.ui.cryptolist

import com.example.calculator.domain.model.CoinListItemModel
import javax.inject.Inject

class CoinListScreenMapper @Inject constructor() {
    fun map(coins: List<CoinListItemModel>): List<CoinListUiModel> {
        return coins.map {
            CoinListUiModel(
                id = it.id,
                name = it.name,
                symbol = it.symbol,
                photo = it.photo,
                rank = it.rank,
            )
        }
    }
}