package com.example.calculator.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DrawerList(modifier: Modifier = Modifier) {

    NavigationDrawerItem(
        icon = { Icons.Filled.FavoriteBorder },
        label = { Text(text = "Drawer Item") },
        selected = true,
        onClick = { /*TODO*/ })
    NavigationDrawerItem(
        icon = { Icons.Filled.FavoriteBorder },
        label = { Text(text = "Drawer Item") },
        selected = true,
        onClick = { /*TODO*/ })
}

