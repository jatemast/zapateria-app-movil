package com.example.libreriaonline.model

data class BookCreateRequest(
    val name: String,
    val quantity: Int,
    val price: Double,
    val image: String?
)