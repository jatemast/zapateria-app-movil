package com.example.libreriaonline.repository;

import com.example.libreriaonline.api.ApiService;
import com.example.libreriaonline.model.LoginRequest;
import com.example.libreriaonline.model.LoginResponse;
import com.example.libreriaonline.model.RegistroRequest;
import com.example.libreriaonline.util.TokenManager;
import retrofit2.Response;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/libreriaonline/repository/AuthRepository;", "", "apiService", "Lcom/example/libreriaonline/api/ApiService;", "tokenManager", "Lcom/example/libreriaonline/util/TokenManager;", "(Lcom/example/libreriaonline/api/ApiService;Lcom/example/libreriaonline/util/TokenManager;)V", "login", "Lretrofit2/Response;", "Lcom/example/libreriaonline/model/LoginResponse;", "request", "Lcom/example/libreriaonline/model/LoginRequest;", "(Lcom/example/libreriaonline/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "register", "Lcom/example/libreriaonline/model/RegistroRequest;", "(Lcom/example/libreriaonline/model/RegistroRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.util.TokenManager tokenManager = null;
    
    @javax.inject.Inject
    public AuthRepository(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.util.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object register(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.RegistroRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object login(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.LoginRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.LoginResponse>> $completion) {
        return null;
    }
    
    public final void logout() {
    }
}