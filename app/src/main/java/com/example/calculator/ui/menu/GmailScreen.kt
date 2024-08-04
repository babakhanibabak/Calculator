package com.example.calculator.ui.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.launch

@Composable
fun GmailScreen() {
    GmailScreenContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailScreenContent(modifier: Modifier = Modifier,
                       onBackClick: () -> Unit = {},) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()

    Scaffold(modifier = modifier.fillMaxSize(),
topBar = {
        TopAppBar(
            modifier = Modifier,
            colors = TopAppBarDefaults.topAppBarColors(Color.LightGray),
            title = {
                Text(
                    text = "Gmail",
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
                IconButton(onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu, contentDescription = ""
                    )
                }
            },
            scrollBehavior = scrollBehavior

        )
}
        ) { padding ->
        Column(modifier = Modifier.padding(padding)) {

        }

    }
}


@Preview
@Composable
private fun GmailScreenPreview() {
    CalculatorTheme {
        GmailScreenContent(

        )
    }
}