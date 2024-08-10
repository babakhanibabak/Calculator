package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var isFavorite by remember {
        mutableStateOf(false)
    }
    Card(modifier=modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CircleImage(imageId = R.drawable.bit, modifier = modifier.weight(1f))
        Text(text = "Text", modifier = Modifier.weight(2f))
        IconButton(onClick = { isFavorite = !isFavorite }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star,
                modifier = Modifier.weight(0.8f),
                contentDescription = ""
            )
        }
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