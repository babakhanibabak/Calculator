package com.example.calculator.data.repository

import com.example.calculator.data.datasource.local.CoinDataProvider
import com.example.calculator.data.model.mapToDomainModel
import com.example.calculator.domain.model.CoinDetailModel
import com.example.calculator.domain.model.CoinListItemModel
import com.example.calculator.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinDataProvider: CoinDataProvider,
) : CoinRepository {

    override suspend fun getCoinsList(): List<CoinListItemModel> {
        return coinDataProvider.getCoinsList()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailModel {
        return mapToDomainModel(coinDataProvider.getCoinDetail(coinId))
    }
}