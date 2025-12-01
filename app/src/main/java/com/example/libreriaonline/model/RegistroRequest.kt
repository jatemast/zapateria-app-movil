package com.example.libreriaonline.model

data class RegistroRequest(
    val name: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
    val latitude: String,
    val longitude: String
)