package com.example.calculator.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.versionedparcelable.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun ProductDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }) {
            Text(
                text = "ItemName", modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector =
                    if (expanded) {
                        Icons.Default.ArrowDropDown
                    } else {
                        Icons.Default.KeyboardArrowUp
                    },
                    contentDescription = ""
                )
            }
            DropdownMenu(expanded = expanded,
                onDismissRequest = { expanded = false }) {

            }
        }
    }


}

data class Product(
    val id: String,
    val name: String
)

object ProductDataProvider {
    fun AllProducts()= arrayListOf(
        Product(id = "1","nike"),
        Product(id = "2", name = "zara"),
        Product("3","LccWiki"),
        Product("4","eco"),
        Product("5","JosefSiebel")
    )
}

@Preview
@Composable
private fun DropDownMenuPreview() {
    CalculatorTheme {
        ProductDropDownMenu()
    }
}