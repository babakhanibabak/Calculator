package com.example.calculator.data

import com.example.calculator.domain.CoinListDataProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindCoinListDataProvider(impl: CoinListDataProviderImpl): CoinListDataProvider
}