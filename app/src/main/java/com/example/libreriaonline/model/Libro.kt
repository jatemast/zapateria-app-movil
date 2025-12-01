package com.example.libreriaonline.model

import com.google.gson.annotations.SerializedName

data class Libro(
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: Double,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("updated_at") val updatedAt: String?
)

