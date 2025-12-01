package com.example.libreriaonline.repository

import com.example.libreriaonline.api.ApiService
import com.example.libreriaonline.model.LoginRequest
import com.example.libreriaonline.model.LoginResponse
import com.example.libreriaonline.model.RegistroRequest
import com.example.libreriaonline.model.User
import com.example.libreriaonline.model.UserUpdateRequest
import com.example.libreriaonline.model.UserUpdateResponse
import com.example.libreriaonline.util.TokenManager
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val apiService: ApiService,
    private val tokenManager: TokenManager
) {

    suspend fun register(request: RegistroRequest): Response<Unit> {
        return apiService.register(request)
    }

    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        val response = apiService.login(request)
        if (response.isSuccessful && response.body() != null) {
            tokenManager.saveToken(response.body()!!.token)
        }
        return response
    }

    fun logout() {
        tokenManager.deleteToken()
    }

    suspend fun getUser(): Response<User> {
        return apiService.getUser()
    }

    suspend fun updateUser(request: UserUpdateRequest): Response<UserUpdateResponse> {
        return apiService.updateUser(request)
    }
}