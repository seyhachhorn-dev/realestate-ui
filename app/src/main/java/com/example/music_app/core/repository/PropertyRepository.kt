package com.example.music_app.core.repository

import com.example.music_app.core.model.PropertyResponse
import com.example.music_app.core.network.PropertyApiService
import retrofit2.Response

class PropertyRepository(private val apiService: PropertyApiService) {
    suspend fun getProperties(
        page: Int = 1,
        size: Int = 10,
        sortBy: String = "price",
        sortDir: String = "desc"
    ): Response<PropertyResponse> {
        return apiService.getProperties(page, size, sortBy, sortDir)
    }
}
