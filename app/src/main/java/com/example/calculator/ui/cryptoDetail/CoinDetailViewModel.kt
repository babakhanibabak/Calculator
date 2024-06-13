package com.example.calculator.ui.cryptoDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.domain.CoinDetailModel
import com.example.calculator.domain.CoinDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
private val coinDetailRepository:CoinDetailRepository,
    private val mapper: CoinDetailScreenMapper
):ViewModel() {
private val _uiState= MutableStateFlow(CoinDetailScreenState())
    val uiState=_uiState.asStateFlow()
init {
    loadData()
}
    private fun loadData(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true)
            }
            runCatching {
                coinDetailRepository.getCoinDetail(coinId = "")
            }.onSuccess {
            _uiState.update { it.copy(isLoading = false, showDetailData = mapper.mapToUiModel(model = CoinDetailModel())) }
            }.onFailure {
                error-> _uiState.update {
                it.copy(isLoading = false, error = error.message.toString())
            }  }
        }
    }
}