package com.example.calculator.ui.basiccalculator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BasicCalculatorViewModel @Inject constructor(): ViewModel(){
private val _uiState = MutableStateFlow(BasicCalculatorScreenUiState())
    val uiState=_uiState.asStateFlow()

    fun onFirstNumberClick(value:String){
        _uiState.update { it.copy(firstNumber = value) }
    }
    fun onSecondNumberClick(value:String){
        _uiState.update { it.copy(secondNumber = value) }
    }
    fun onPlusClick(){
        val result = _uiState.value.firstNumber.toInt() + _uiState.value.secondNumber.toInt()
        _uiState.update { it.copy(
            result=result.toString()
        ) }
    }

}