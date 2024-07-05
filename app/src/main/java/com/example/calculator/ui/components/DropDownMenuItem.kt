package com.example.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun ProductDropDownMenu(
    modifier: Modifier = Modifier,
    items: List<Product>,
    selectedProductItem: Product? = null,
    onSelectedItem: (Product) -> Unit = {}
) {

    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier.background(Color.LightGray)) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedProductItem?.name ?: "product name",
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector =
                if (expanded) {
                    Icons.Default.ArrowDropDown
                } else {
                    Icons.Default.KeyboardArrowUp
                },
                contentDescription = ""
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },

                ) {
                items.forEach { product ->
                    DropdownMenuItem(
                        text = { Text(text = product.name) },
                        onClick = {
                            expanded = false
                            onSelectedItem(product)

                        })
                }
            }
        }
    }


}

data class Product(
    val id: String,
    val name: String
)

object ProductDataProvider {
    fun allProducts() = arrayListOf(
        Product(id = "1", "nike"),
        Product(id = "2", name = "zara"),
        Product("3", "LccWiki"),
        Product("4", "eco"),
        Product("5", "JosefSiebel")
    )
}

@Preview
@Composable
private fun DropDownMenuPreview() {
    CalculatorTheme {
        ProductDropDownMenu(
            items = ProductDataProvider.allProducts(),
            selectedProductItem = ProductDataProvider.allProducts()[0]
        )
    }
}