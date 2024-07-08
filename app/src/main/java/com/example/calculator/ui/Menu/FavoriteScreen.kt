package com.example.calculator.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.black),
            contentDescription = ""
        )
        Text(text = "NIKE", textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.size(20.dp))

        Image(
            painter = painterResource(id = R.drawable.red),
            contentDescription = ""
        )
        Text(text = "ECO")

    }
}

@Preview
@Composable
private fun FavoriteScreenPreview() {
    CalculatorTheme{
        FavoriteScreen()
    }
}
