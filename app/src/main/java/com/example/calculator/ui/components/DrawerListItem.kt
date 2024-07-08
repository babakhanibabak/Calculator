package com.example.calculator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun DrawerList() {

    NavigationDrawerItem(
        icon = { Icon(imageVector = Icons.Rounded.ShoppingCart, contentDescription = "") },
        label = { Text(text = "Shopping") },
        selected = true,
        onClick = { /*TODO*/ })
    Spacer(modifier = Modifier.size(8.dp))
    NavigationDrawerItem(
        icon = { Icon(modifier = Modifier.clickable {  },imageVector = Icons.Filled.FavoriteBorder, contentDescription = "") },
        label = { Text(text = "Favorite Items", textAlign = TextAlign.End) },
        badge = { Icon(modifier = Modifier.clickable {  }, imageVector = Icons.Filled.Edit, contentDescription = "") },
        selected = true,
        onClick = {})
    Spacer(modifier = Modifier.size(8.dp))
    NavigationDrawerItem(
        icon = {Icon(imageVector = Icons.Rounded.Settings, contentDescription = "") },
        label = { Text(text = "Settings", textAlign = TextAlign.End) },
        selected =true ,
        onClick = { /*TODO*/ })
    Spacer(modifier = Modifier.size(8.dp))
    NavigationDrawerItem(
        icon = {Icon(imageVector = Icons.Rounded.Share, contentDescription = "") },
        label = { Text(text = "Share", textAlign = TextAlign.End) },
        selected =true ,
        onClick = { /*TODO*/ })
    Spacer(modifier = Modifier.size(8.dp))
    NavigationDrawerItem(
        icon = {Icon(imageVector = Icons.Rounded.AccountCircle, contentDescription = "") },
        label = { Text(text = "Account", textAlign = TextAlign.End) },
        selected =true ,
        onClick = { /*TODO*/ })

}

@Preview
@Composable
private fun DrawerListPreview() {
    CalculatorTheme {
        DrawerList()
    }
}