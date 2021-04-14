package com.therickandmorty.data.remote

import com.google.gson.GsonBuilder
import com.therickandmorty.data.model.CharactersList
import com.therickandmorty.data.model.EpisodesList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface TheRickAndMortyClient {

    companion object {
        private const val baseUtl = "https://rickandmortyapi.com/api/"

        private fun getGson() = GsonBuilder().setLenient().create()

        private fun getLogger() = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private fun getOkHttp() = OkHttpClient.Builder()
            .addInterceptor(getLogger())
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        private fun getRetrofit() = Retrofit.Builder()
            .baseUrl(baseUtl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .build()

        operator fun invoke() = getRetrofit().create(TheRickAndMortyClient::class.java)
    }

    @GET("character")
    suspend fun getCharactersList(): CharactersList

    @GET("episode")
    suspend fun getEpisodesList(): EpisodesList


}