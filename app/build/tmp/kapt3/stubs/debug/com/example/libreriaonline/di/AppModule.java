package com.example.libreriaonline.di;

import android.content.Context;
import com.example.libreriaonline.api.ApiService;
import com.example.libreriaonline.network.RetrofitClient;
import com.example.libreriaonline.repository.AuthRepository;
import com.example.libreriaonline.repository.BookRepository;
import com.example.libreriaonline.util.TokenManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/libreriaonline/di/AppModule;", "", "()V", "provideApiService", "Lcom/example/libreriaonline/api/ApiService;", "retrofitClient", "Lcom/example/libreriaonline/network/RetrofitClient;", "provideAuthRepository", "Lcom/example/libreriaonline/repository/AuthRepository;", "apiService", "tokenManager", "Lcom/example/libreriaonline/util/TokenManager;", "provideBookRepository", "Lcom/example/libreriaonline/repository/BookRepository;", "provideRetrofitClient", "provideTokenManager", "context", "Landroid/content/Context;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.libreriaonline.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.util.TokenManager provideTokenManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.network.RetrofitClient provideRetrofitClient(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.util.TokenManager tokenManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.api.ApiService provideApiService(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.network.RetrofitClient retrofitClient) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.util.TokenManager tokenManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.repository.BookRepository provideBookRepository(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.api.ApiService apiService) {
        return null;
    }
}