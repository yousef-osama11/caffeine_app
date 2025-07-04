package com.example.caffeine.presentation.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.caffeine.CustomizeCoffeeScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CustomizeCoffeeViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val args = savedStateHandle.toRoute<CustomizeCoffeeScreen>()

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()

    init {
        _state.update { args.name }
    }

}