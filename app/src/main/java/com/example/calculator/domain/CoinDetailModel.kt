package com.example.calculator.domain

data class CoinDetailModel(
    val message:String="",
    val description:String="",
    val firstPrice:Int?=null,
    val lastPrice:Int?=null
)
