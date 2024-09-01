package com.example.pwapplication.data.network

import com.example.pwapplication.data.model.ApiResponse
import com.example.pwapplication.data.model.Character
import com.example.pwapplication.data.model.CharacterDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): ApiResponse<Character>

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): CharacterDetail
}