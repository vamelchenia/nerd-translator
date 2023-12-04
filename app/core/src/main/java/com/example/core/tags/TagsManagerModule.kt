package com.example.core.tags

import org.koin.dsl.module

val tagsManagerModule = module {
    single<TagsManagerRepository> {
        return@single TagsManagerRepositoryImpl()
    }
}