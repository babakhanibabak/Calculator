package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun DrawerListItem(modifier: Modifier = Modifier) {
    DrawerListItemContent()
}

@Composable
fun DrawerListItemContent(modifier: Modifier = Modifier) {
Card {
    Row (modifier=modifier){
        CircleImage(imageId = R.drawable.bit)
        Text(text = "Text")
       Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = "")
    }
}
}

@Preview
@Composable
private fun DrawerListItemContentPreview() {
    CalculatorTheme {
        DrawerListItemContent()
    }
}