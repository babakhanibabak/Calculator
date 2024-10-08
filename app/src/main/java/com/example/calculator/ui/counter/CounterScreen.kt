package com.example.calculator.ui.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calculator.ui.common.buildTestTag
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun CounterScreen(
    viewModel: CounterViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    CounterScreenContent(
        uiState = uiState,
        onPlusClick = viewModel::onPlusClick,
        onMinusClick = viewModel::onMinusClick,
        onResetClick = viewModel::onResetClick,
        onBackClick = onBackClick
    )
}

@Composable
private fun CounterScreenContent(
    modifier: Modifier = Modifier,
    uiState: Int,
    onPlusClick: () -> Unit = {},
    onMinusClick: () -> Unit = {},
    onResetClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Scaffold(modifier = modifier
        .fillMaxSize(),
        topBar = { MyAppBar(title = "Number Counter") { onBackClick() } },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onResetClick,
                containerColor = Color.Magenta,
                contentColor = Color.Gray,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                modifier = Modifier.buildTestTag("fab")
            ) {
                Text(text = "Reset")
            }
        }
    ) { padding ->
        Column(
            modifier = modifier
                .padding(padding)
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Result(uiState = uiState)
            Spacer(modifier = Modifier.size(64.dp))
            Operators(onPlusClick = onPlusClick, onMinusClick = onMinusClick)
            Spacer(modifier = Modifier.size(32.dp))
            OperationButton(
                modifier = Modifier.buildTestTag("reset_button"),
                onClick = onResetClick,
                text = "Reset",
                fontSize = 22.sp,
                color = Color.Blue
            )
        }
    }
}

@Composable
fun Result(
    modifier: Modifier = Modifier,
    uiState: Int,
) {
    Box(
        modifier = modifier
            .size(120.dp)
            .border(2.dp, Color.Black, CircleShape)
            .clip(CircleShape)
            .background(Color.Yellow)
            .buildTestTag("result_circle_box"),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .buildTestTag("result_text"),
            text = uiState.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
        )
    }
}

@Composable
fun Operators(
    modifier: Modifier = Modifier,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OperationButton(
            modifier = Modifier
                .weight(0.5f)
                .buildTestTag("plus_button"),
            onClick = onPlusClick,
            text = "+",
            fontSize = 30.sp,
            color = Color.Green
        )
        Spacer(modifier = Modifier.size(32.dp))
        OperationButton(
            modifier = Modifier
                .weight(0.5f)
                .buildTestTag("minus_button"),
            onClick = onMinusClick,
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

@Preview
@Composable
private fun CounterScreenContentPreview() {
    CalculatorTheme {
        CounterScreenContent(uiState = 0)

    }
}