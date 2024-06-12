package com.example.calculator.data

import com.example.calculator.domain.CoinDetailModel
import com.example.calculator.domain.CoinDetailRepository
import javax.inject.Inject

class CoinDetailDataImpl @Inject constructor():CoinDetailRepository {
    override suspend fun getCoinDetail(coinId: String): CoinDetailModel {
        return super.getCoinDetail(coinId)
    }
}