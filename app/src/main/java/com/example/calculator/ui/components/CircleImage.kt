package com.example.calculator.ui.components

import androidx.annotation.Size
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.calculator.R
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(width = 200.dp, height = 200.dp),
    imageId: Int
) {
    Image(
        modifier = modifier
            .clip(CircleShape)
            .border(BorderStroke(width = 1.dp, color = Color.LightGray), shape = CircleShape)
            .size(size),
        painter = painterResource(id = imageId),
        contentDescription = ""
    )
}

@Preview
@Composable
private fun CircleImagePreview() {
    CalculatorTheme {
        CircleImage(
            modifier = Modifier,
            size = DpSize(120.dp, 120.dp),
            imageId = R.drawable.bit
        )
    }
}