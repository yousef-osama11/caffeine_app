package com.example.caffeine.presentation.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.caffeine.CoffeeSelectionScreen
import com.example.caffeine.presentation.TempState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CoffeeSelectionViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val args = savedStateHandle.toRoute<CoffeeSelectionScreen>()

    val _state = MutableStateFlow(TempState())
    val state = _state.asStateFlow()

    init {
        _state.update { it.copy(name = args.name, age = args.age) }
    }
}