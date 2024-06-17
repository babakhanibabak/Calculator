package com.example.calculator.data

import com.example.calculator.data.repository.CoinRepositoryImpl
import com.example.calculator.domain.repository.CoinRepository
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
    fun bindCoinDetailRepository(impl: CoinRepositoryImpl): CoinRepository
}