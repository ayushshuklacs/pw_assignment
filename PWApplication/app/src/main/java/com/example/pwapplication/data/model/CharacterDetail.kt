package com.example.pwapplication.data.model

data class CharacterDetail(    val id: Int,
                               val name: String,
                               val status: String,
                               val species: String,
                               val gender: String,
                               val origin: Origin,
                               val image: String
)

data class Origin(
    val name: String
)
