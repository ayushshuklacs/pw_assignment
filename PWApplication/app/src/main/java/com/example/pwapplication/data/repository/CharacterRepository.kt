package com.example.pwapplication.data.repository

import com.example.pwapplication.data.model.Character
import com.example.pwapplication.data.model.CharacterDetail
import com.example.pwapplication.data.network.ApiService

class CharacterRepository(private val apiService: ApiService) {

    suspend fun getCharacters(): List<Character> {
        return apiService.getCharacters().results
    }

    suspend fun getCharacterDetail(id: Int): CharacterDetail {
        return apiService.getCharacterDetail(id)
    }
}