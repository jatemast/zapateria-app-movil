package com.example.libreriaonline.api

import com.example.libreriaonline.model.BookCreateRequest
import com.example.libreriaonline.model.BookUpdateRequest
import com.example.libreriaonline.model.Libro
import com.example.libreriaonline.model.LoginRequest
import com.example.libreriaonline.model.LoginResponse
import com.example.libreriaonline.model.RegistroRequest
import com.example.libreriaonline.model.User
import com.example.libreriaonline.model.UserUpdateRequest
import com.example.libreriaonline.model.UserUpdateResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("register")
    suspend fun register(@Body request: RegistroRequest): Response<Unit>

    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("books")
    suspend fun getLibros(): Response<List<Libro>>

    @GET("books/search")
    suspend fun searchLibros(@Query("query") query: String): Response<List<Libro>>

    @GET("books/{id}")
    suspend fun getLibro(@Path("id") id: Int): Response<Libro>

    @POST("books")
    suspend fun createLibro(@Body request: BookCreateRequest): Response<Libro>

    @PUT("books/{id}")
    suspend fun updateLibro(@Path("id") id: Int, @Body request: BookUpdateRequest): Response<Libro>

    @DELETE("books/{id}")
    suspend fun deleteLibro(@Path("id") id: Int): Response<Unit>

    @POST("books/{id}/purchase")
    suspend fun purchaseLibro(@Path("id") id: Int): Response<Map<String, String>>

    @POST("logout")
    suspend fun logout(): Response<Map<String, String>>

    @GET("user")
    suspend fun getUser(): Response<User>

    @PUT("user")
    suspend fun updateUser(@Body request: UserUpdateRequest): Response<UserUpdateResponse>
}