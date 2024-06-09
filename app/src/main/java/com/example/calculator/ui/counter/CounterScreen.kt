package com.example.calculator.ui.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.basiccalculator.BasicCalculatorViewModel
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CounterScreen(
    viewModel: BasicCalculatorViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CounterScreenContent()
}

@Composable
private fun CounterScreenContent(
    modifier: Modifier = Modifier,

    ) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircleText()
            Spacer(modifier = Modifier.size(32.dp))
            Operators()
            Spacer(modifier =Modifier.size(32.dp))
            ResetButton ()
        }
    }
}

//@Composable
//fun Circle(modifier: Modifier = Modifier) {
//    Box(
//        modifier = modifier
//            .size(120.dp)
//            .border(2.dp, Color.Black, CircleShape)
//            .padding(1.dp)
//            .clip(CircleShape)
//            .background(Color.Yellow),
//    )
//}

@Composable
fun CircleText(modifier: Modifier = Modifier) {
    Text(modifier = modifier
        .background(Color.Yellow, shape = CircleShape)
        .padding(8.dp)
        .size(50.dp),
        textAlign = TextAlign.Center ,text = "0",
        color = Color.Black)
}

@Composable
fun Operators(
    modifier: Modifier = Modifier,
    onIncrementClick: () -> Unit = {},
    onDecrementClick: () -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OperationButton(
            modifier = Modifier.weight(0.5f),
            onClick = onIncrementClick,
            text = "+",
            fontSize = 30.sp,
            color = Color.Green
        )
        Spacer(modifier = Modifier.size(32.dp))
        OperationButton(
            modifier = Modifier.weight(0.5f),
            onClick = onDecrementClick,
            text = "–",
            fontSize = 30.sp,
            color = Color.Red
        )
    }
}

@Composable
fun OperationButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    fontSize: TextUnit,
    color: Color
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        onClick = onClick
    ) {
        Text(text = text, fontSize = fontSize)
    }
}

@Composable
fun ResetButton(
    modifier: Modifier = Modifier,
    onResetClick: () -> Unit={}
) {
    Row (modifier = modifier.fillMaxWidth()){
        OperationButton(
            modifier = Modifier,
            onClick = onResetClick,
            text = "Reset",
            fontSize = 40.sp,
            color = Color.Blue
        )
    }
}

@Preview
@Composable
private fun CounterScreenContentPreview() {
    CalculatorTheme {
        CounterScreenContent()

    }

}