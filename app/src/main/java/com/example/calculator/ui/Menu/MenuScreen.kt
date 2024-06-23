package com.example.calculator.ui.Menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.components.MyAppBar
import com.example.calculator.ui.theme.CalculatorTheme

@Composable
fun MenuScreen(
    viewModel: MenuScreenViewModel= hiltViewModel(),
    onBackClick: () -> Unit

) {
    val uiState by viewModel.uiState.collectAsState()

    MenuScreenContent(onBackClick=onBackClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreenContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier,
                colors = TopAppBarDefaults.topAppBarColors(Color.LightGray),
                title = {
                    Text(
                        text = "Menu",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Filled.Menu, contentDescription = ""
                        )
                    }
                },
                scrollBehavior = scrollBehavior

            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}


@Preview
@Composable
private fun AppBarScreenContentPreview() {
    CalculatorTheme {
        MenuScreenContent()
    }
}