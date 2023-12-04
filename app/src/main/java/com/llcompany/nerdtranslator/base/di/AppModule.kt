package com.llcompany.nerdtranslator.base.di

import com.example.core.tags.tagsManagerModule
import org.koin.dsl.module

val appModule =
    module {
        // TODO: implement
    }

val appModules = listOf(
    appModule,
    tagsManagerModule,
    viewModelModule
)