package com.example.pwapplication.data.model

data class ApiResponse<T>(
    val results: List<T>)