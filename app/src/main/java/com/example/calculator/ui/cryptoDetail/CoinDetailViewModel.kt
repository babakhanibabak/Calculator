package com.example.calculator.ui.cryptoDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.domain.model.CoinDetailModel
import com.example.calculator.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
    private val mapper: CoinDetailScreenMapper,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val coinId by lazy { savedStateHandle.get<String>("coinId") ?: "" }

    private val _uiState = MutableStateFlow(CoinDetailScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            runCatching {
                coinRepository.getCoinDetail(coinId = coinId)
            }.onSuccess { model ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        showDetailData = mapper.mapToUiModel(model = model),
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(isLoading = false, error = error.message.toString())
                }
            }
        }
    }
}