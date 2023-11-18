package com.example.core.network

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    factory {
        provideHttpClient(androidContext())
    }

    single<Retrofit> {
        Retrofit
            .Builder()
            .baseUrl("")
            .client(get())
            .build()
    }

    single {
        provideNetworkApi(get())
    }

    single<NerdTranslatorRepository> {
        NerdTranslatorRepositoryImpl(get())
    }
}

private fun provideNetworkApi(retrofit: Retrofit): NerdTranslatorService {
    return retrofit.create(NerdTranslatorService::class.java)
}

private fun provideHttpClient(context: Context) {
    val cacheSize = (10 * 1024 * 1024).toLong()
    val cache = Cache(context.cacheDir, cacheSize)

    val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    OkHttpClient()
        .newBuilder()
        .addInterceptor(logger)
        .cache(cache)
        .build()
}