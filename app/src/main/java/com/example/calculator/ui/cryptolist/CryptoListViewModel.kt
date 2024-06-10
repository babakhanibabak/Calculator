package com.example.calculator.ui.cryptolist

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor() : ViewModel() {
private val _uiState= MutableStateFlow("")
    val uiState=_uiState.asStateFlow()


}