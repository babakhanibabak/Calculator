package com.example.calculator.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun DrawerList(modifier: Modifier = Modifier) {

    NavigationDrawerItem(
        icon = { Icons.Rounded.ShoppingCart },
        label = { Text(text = "Drawer Item") },
        selected = true,
        onClick = { /*TODO*/ })
    Spacer(modifier = Modifier.size(8.dp))
    NavigationDrawerItem(
        icon = { Icons.Filled.FavoriteBorder },
        label = { Text(text = "Drawer Item", textAlign = TextAlign.End) },
        badge = { Icons.Filled.FavoriteBorder},
        selected = true,
        onClick = { /*TODO*/ })
}

@Preview
@Composable
private fun DrawerListPreview() {
    CalculatorTheme{
        DrawerList()
    }
}