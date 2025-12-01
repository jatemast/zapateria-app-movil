package com.example.libreriaonline.model

import com.google.gson.annotations.SerializedName

data class Libro(
    val id: Int,
    val name: String,
    val quantity: Int,
    val price: String, // Cambiado a String según la respuesta de la API
    val image_url: String,
    val created_at: String,
    val updated_at: String
)

data class BookCreateRequest(
    val name: String,
    val quantity: Int,
    val price: Double,
    val image: String // Base64 string
)

data class BookUpdateRequest(
    val name: String? = null,
    val quantity: Int? = null,
    val price: Double? = null,
    val image: String? = null // Base64 string
)