package com.example.calculator.ui.cryptoDetail

import com.example.calculator.domain.CoinDetailModel
import javax.inject.Inject

class CoinDetailScreenMapper @Inject constructor() {
fun mapToUiModel(model: CoinDetailModel): CoinDetailUiModel {
    return CoinDetailUiModel(
        message = model.message,
        description = model.description,
        firstPrice = model.firstPrice,
        lastPrice = model.lastPrice
    )
}
}