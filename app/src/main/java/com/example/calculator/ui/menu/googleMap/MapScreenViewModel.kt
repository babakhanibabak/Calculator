package com.example.calculator.ui.menu.googleMap

import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MapScreenViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(
        MapScreenState(
            uiSettings = MapUiSettings(),
            mapProperties = MapProperties(),
            currentLocation = LatLng(41.015137, 28.979530),
        )
    )
    val uiState by lazy {
changeLocation()
        _uiState.asStateFlow() }

    private fun changeLocation() {
        _uiState.update {
            it.copy(currentLocation = LatLng(43.015137, 40.979530))
        }
    }
}