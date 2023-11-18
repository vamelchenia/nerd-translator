package com.example.core.network

import retrofit2.http.GET
import retrofit2.http.Query

interface NerdTranslatorService {

    // TODO: substitute with actual endpoint names and parameters
    @GET("supported_languages")
    suspend fun getSupportedLanguagesList()

    @GET("translation")
    suspend fun getTranslation(
        @Query("query") query: String,
        @Query("sourceLanguage") srcLanguage: String,
        @Query("destinationLanguage") destLanguage: String
    )
}