package com.example.calculator.ui.counter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(0)
    val uiState by lazy {
        countToTen()
        _uiState.asStateFlow()
    }

    private fun countToTen() {
        viewModelScope.launch {
            for (i in 1..10) {
                delay(1000)
                _uiState.value = i
            }
        }
    }

    fun onPlusClick() {
        _uiState.value++
    }

    fun onMinusClick() {
        _uiState.value--
    }

    fun onResetClick() {
        _uiState.value = 0
    }
}