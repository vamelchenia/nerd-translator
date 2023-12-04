package com.llcompany.nerdtranslator.base.di

import com.example.mainscreen.MainScreenViewModel
import com.example.createtagsheet.CreateTagSheetViewModel
import com.example.favouritesscreen.FavouritesScreenViewModel
import com.llcompany.nerdtranslator.base.main.BottomSheetViewModel
import com.llcompany.nerdtranslator.base.main.TopAppBarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel {
            TopAppBarViewModel()
        }

        viewModel {
            BottomSheetViewModel(get())
        }

        viewModel {
            MainScreenViewModel()
        }

        viewModel {
            FavouritesScreenViewModel(get())
        }

        viewModel {
            CreateTagSheetViewModel()
        }
    }