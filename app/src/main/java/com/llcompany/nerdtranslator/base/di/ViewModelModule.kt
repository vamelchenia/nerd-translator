package com.llcompany.nerdtranslator.base.di

import com.example.mainscreen.MainScreenViewModel
import com.example.favouritesscreen.FavouritesScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel {
            MainScreenViewModel()
            FavouritesScreenViewModel()
        }
    }