package com.example.caffeine.di

import com.example.caffeine.presentation.screen.CoffeeSelectionViewModel
import com.example.caffeine.presentation.screen.CustomizeCoffeeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module{
    viewModelOf(::CoffeeSelectionViewModel)
    viewModelOf(::CustomizeCoffeeViewModel)
}

