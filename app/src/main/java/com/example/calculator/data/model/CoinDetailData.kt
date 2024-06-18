package com.example.calculator.data.model

import com.example.calculator.domain.model.CoinDetailModel

data class CoinDetailData(
    val message:String,
    val description:String,
    val firstPrice:Int,
    val lastPrice: Int,
)

fun mapToDomainModel(dto: CoinDetailData): CoinDetailModel {
    return CoinDetailModel(
        message = dto.message,
        description = dto.description,
        firstPrice = dto.firstPrice,
        lastPrice = dto.lastPrice
    )
}