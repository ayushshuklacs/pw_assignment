package com.example.pwapplication.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    const val BASE_URL = "https://rickandmortyapi.com/api/"



    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // Use the base URL from ApiConfig
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}