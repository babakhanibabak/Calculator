package com.example.calculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculator.ui.basiccalculator.BasicCalculatorScreen
import com.example.calculator.ui.logInScreen.LogInScreen
import com.example.calculator.ui.logInScreen.OnBasicCalculator
import com.example.calculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                // TODO: Practice 1: Add navigation with navigation screen with two buttons
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "LoginScreen") {
                    composable(route = "LoginScreen") {
                        LogInScreen(navController = navController)
                    }
                    composable("BasicCalculatorScreen") {
                        BasicCalculatorScreen()
                    }
                }
            }
        }
    }}