package com.example.calculator.ui.counter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class CounterViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(0)
    val uiState=_uiState.asStateFlow()
    fun increment() {
        _uiState.value++
    }
fun decrement() {
    _uiState.value--

}
}