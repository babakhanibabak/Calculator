package com.example.calculator.ui.cryptolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
    private val mapper: CoinListScreenMapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CoinListScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            runCatching {
                coinRepository.getCoinsList()
            }.onSuccess { coins ->
                _uiState.update { it.copy(isLoading = false, dataList = mapper.map(coins)) }
            }.onFailure { error ->
                _uiState.update { it.copy(isLoading = false, error = error.message.toString()) }
            }
        }
    }
}