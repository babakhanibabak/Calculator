package com.example.calculator.ui.Menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier

) {
    MenuScreenContent()
}

@Composable
fun MenuScreenContent(modifier: Modifier = Modifier,
                      onBackClick:() -> Unit={}
                      ) {
    Scaffold(modifier = modifier.fillMaxSize(),
    topBar = { MyAppBar(
        title = "Menu", onBackClick =onBackClick
    )}
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}


@Preview
@Composable
private fun AppBarScreenContentPreview() {
    CalculatorTheme {
        MenuScreenContent()
    }
}