package com.example.calculator.ui.cryptolist

import com.example.calculator.R
import javax.inject.Inject

data class CryptoList(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
   val photo:Int
)

class CoinListModel @Inject constructor(id: String, name: String, symbol: String, rank: Int, photo:Int){
    fun getCoinImage():List<CryptoList>{
        return listOf(
            CryptoList("1","Bitcoin","BTC",1, photo = R.drawable.bit),
            CryptoList("2","tether","tet",1, photo = R.drawable.tether),
            CryptoList("3","ethereum","eth",1, photo = R.drawable.ethereum),
            CryptoList("4","usdc","usd",1, photo = R.drawable.usdc)
        )
    }
}