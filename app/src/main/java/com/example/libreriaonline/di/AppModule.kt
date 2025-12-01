package com.example.libreriaonline.di

import android.content.Context
import com.example.libreriaonline.api.ApiService
import com.example.libreriaonline.network.RetrofitClient
import com.example.libreriaonline.repository.AuthRepository
import com.example.libreriaonline.repository.BookRepository
import com.example.libreriaonline.util.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
 
 @Module
 @InstallIn(SingletonComponent::class)
 object AppModule {
 
    @Provides
    @Singleton
    fun provideTokenManager(@ApplicationContext context: Context): TokenManager {
        return TokenManager(context)
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(tokenManager: TokenManager): RetrofitClient {
        return RetrofitClient(tokenManager)
    }

     @Provides
     @Singleton
     fun provideApiService(retrofitClient: RetrofitClient): ApiService {
         return retrofitClient.apiService
     }
 
     @Provides
     @Singleton
     fun provideAuthRepository(apiService: ApiService, tokenManager: TokenManager): AuthRepository {
         return AuthRepository(apiService, tokenManager)
     }
 
     @Provides
     @Singleton
     fun provideBookRepository(apiService: ApiService): BookRepository {
         return BookRepository(apiService)
     }
 }