package com.example.calculator.ui.menu.googleMap

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapScreenViewModel @Inject constructor() : ViewModel() {
    var uiSettings = mutableStateOf(MapUiSettings())
    var properties = mutableStateOf(MapProperties())
}