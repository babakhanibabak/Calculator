package com.example.calculator.domain

import com.example.calculator.data.CoinDetailData
import com.example.calculator.data.mapToDomainModel

interface CoinDetailRepository {
    suspend fun getCoinDetail(coinId: String): CoinDetailModel {
        return mapToDomainModel(
            CoinDetailData(
                description = coinId,
                message = coinId,
                firstPrice = coinId.toInt(),
                lastPrice = coinId.toInt(),
            )
        )
    }
}