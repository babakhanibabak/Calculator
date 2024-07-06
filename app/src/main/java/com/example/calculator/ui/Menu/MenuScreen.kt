package com.example.calculator.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.windowInsets
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import com.example.calculator.R
import com.example.calculator.ui.components.DrawerList
import com.example.calculator.ui.components.Product
import com.example.calculator.ui.components.ProductDataProvider
import com.example.calculator.ui.components.ProductDropDownMenu
import com.example.calculator.ui.theme.CalculatorTheme
import kotlinx.coroutines.launch

@Composable
fun MenuScreen(
    viewModel: MenuScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState(MenuScreenState())

    MenuScreenContent(
        onBackClick = onBackClick,
        uiState = uiState,
        onFavoriteClick = onFavoriteClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreenContent(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    uiState: MenuScreenState,
    onFavoriteClick: () -> Unit = {},
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val bottomScrollBehavior = BottomAppBarDefaults.exitAlwaysScrollBehavior()


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = modifier) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Text(
                        text = "Drawer Title",
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center
                    )
                }

                HorizontalDivider()
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    DrawerList()
                }


            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(modifier = Modifier.fillMaxSize(),
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
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.offset(y = 4.dp),
                    onClick = { /*TODO*/ },
                    containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                    contentColor = Color.Blue,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                    shape = FloatingActionButtonDefaults.largeShape
                ) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "")
                }
            },
            bottomBar = {
                BottomAppBar(
                    windowInsets = windowInsets,
                    containerColor = Color.Blue.copy(0.5f),
                    scrollBehavior = bottomScrollBehavior
                ) {
                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            IconButton(onClick = onFavoriteClick) {
                                Icon(Icons.Filled.Favorite, contentDescription = "Favorites")
                            }

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.DateRange, contentDescription = "date range")
                            }

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Place, contentDescription = "date range")
                            }

                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Filled.Email, contentDescription = "Favorites")
                            }
                        }
                    }
                }
            }) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                verticalArrangement = Arrangement.Center,
            ) {
                var selectedProductItem by remember {
                    mutableStateOf<Product?>(null)
                }
                ProductDropDownMenu(
                    modifier = Modifier.padding(
                        horizontal = 10.dp,
                        vertical = 50.dp
                    ),
                    items = ProductDataProvider.allProducts(),
                    selectedProductItem = selectedProductItem,
                    onSelectedItem = { selectedProductItem = it },

                    )
            }

        }

    }
}

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {

    Column(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bit),
            contentDescription = ""
        )

        Spacer(modifier = Modifier.size(10.dp))

        Image(
            painter = painterResource(id = R.drawable.bit),
            contentDescription = ""
        )

    }
}

@Preview
@Composable
fun MenuScreenContentPreview() {
    CalculatorTheme {
        MenuScreenContent(uiState = MenuScreenState())
    }
}