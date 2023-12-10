package com.example.core.tags

import com.example.core.shared_preferences.PreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val tagsManagerModule = module {
    single {
        PreferencesManager(this.androidContext())
    }
    single<TagsManagerRepository> {
        TagsManagerRepositoryImpl(get())
    }
}