package com.example.libreriaonline.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val email_verified_at: String?,
    val latitude: String?,
    val longitude: String?,
    val created_at: String,
    val updated_at: String
)

data class UserUpdateRequest(
    val name: String,
    val email: String
)

data class UserUpdateResponse(
    val message: String,
    val user: User
)