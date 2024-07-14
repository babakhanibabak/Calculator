package com.example.calculator.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuScreenViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(MenuScreenState())

    val uiState by lazy {
        onFavoriteClick()
        _uiState.asStateFlow()
    }

    fun onFavoriteClick() {
        viewModelScope.launch {
            _uiState.update { it.copy(favorite = true) }
        }
    }

}