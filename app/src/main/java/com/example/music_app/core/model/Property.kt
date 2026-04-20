package com.example.music_app.core.model

import com.google.gson.annotations.SerializedName

data class PropertyResponse(
    val success: Boolean,
    val message: String,
    val data: PropertyData
)

data class PropertyData(
    val content: List<Property>,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int,
    val last: Boolean
)

data class Property(
    val id: Int,
    val type: String,
    val title: String,
    val address: String,
    val pickPath: String,
    val price: Double,
    val bed: Int,
    val bath: Int,
    val size: Int,
    val isGarage: Boolean,
    val score: Double,
    val description: String
)
