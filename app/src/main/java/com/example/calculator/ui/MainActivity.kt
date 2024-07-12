package com.example.calculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculator.ui.basiccalculator.BasicCalculatorScreen
import com.example.calculator.ui.calculator.CalculatorScreen
import com.example.calculator.ui.menu.FavoriteScreen
import com.example.calculator.ui.counter.CounterScreen
import com.example.calculator.ui.cryptoDetail.CoinDetailScreen
import com.example.calculator.ui.cryptolist.CryptoListScreen
import com.example.calculator.ui.menu.DateScreen
import com.example.calculator.ui.menu.MapScreen
import com.example.calculator.ui.menu.MenuScreen
import com.example.calculator.ui.navigation.NavigationScreen
import com.example.calculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "LoginScreen") {
                    composable(route = "LoginScreen") {
                        NavigationScreen(
                            onBasicCalculatorClick = {
                                navController.navigate("BasicCalculatorScreen")
                            },
                            onCalculatorClick = {
                                navController.navigate("CalculatorScreen")
                            },
                            onCounterClick = {
                                navController.navigate("CounterScreen")
                            },
                            onCryptoListClick = {
                                navController.navigate("CryptoListScreen")
                            },
                            onMenuClick = {
                                navController.navigate("MenuScreen")
                            }
                        )
                    }
                    composable("BasicCalculatorScreen") {
                        BasicCalculatorScreen(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("CalculatorScreen") {
                        CalculatorScreen(onBackClick = { navController.popBackStack() })
                    }
                    composable("CounterScreen") {
                        CounterScreen(onBackClick = { navController.popBackStack() })
                    }
                    composable("CryptoListScreen") {
                        CryptoListScreen(
                            onItemClick = { coinId ->
                                navController.navigate("CoinDetailScreen/$coinId")
                            },
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("CoinDetailScreen/{coinId}") {
                        CoinDetailScreen(
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                    composable("MenuScreen") {
                        MenuScreen(
                            onBackClick = { navController.popBackStack() },
                            onFavoriteClick = { navController.navigate("FavoriteScreen") },
                            onFavoriteBorderClick = {navController.navigate("Favorite Items")},
                            onDateClick = {navController.navigate("Date Screen")},
                            onMapClick = {navController.navigate("Map Screen")}
                        )

                    }
                    composable("FavoriteScreen") {
                        FavoriteScreen(onBackClick = { navController.popBackStack() })
                    }
                    composable("Favorite Items"){
                        FavoriteScreen (onBackClick = {navController.popBackStack()})
                    }
                    composable("Date Screen"){
                        DateScreen()
                    }
                    composable("Map Screen"){
                        MapScreen()
                    }
                }
            }
        }
    }
}