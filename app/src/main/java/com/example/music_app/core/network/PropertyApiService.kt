package com.example.music_app.core.network

import com.example.music_app.core.model.PropertyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PropertyApiService {
    @GET("api/v1/property")
    suspend fun getProperties(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("sortBy") sortBy: String,
        @Query("sortDir") sortDir: String
    ): Response<PropertyResponse>
}
