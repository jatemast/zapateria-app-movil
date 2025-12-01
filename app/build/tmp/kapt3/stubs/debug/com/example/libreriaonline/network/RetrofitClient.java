package com.example.libreriaonline.network;

import com.example.libreriaonline.api.ApiService;
import com.example.libreriaonline.util.TokenManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/libreriaonline/network/RetrofitClient;", "", "tokenManager", "Lcom/example/libreriaonline/util/TokenManager;", "(Lcom/example/libreriaonline/util/TokenManager;)V", "BASE_URL", "", "apiService", "Lcom/example/libreriaonline/api/ApiService;", "getApiService", "()Lcom/example/libreriaonline/api/ApiService;", "apiService$delegate", "Lkotlin/Lazy;", "authInterceptor", "Lokhttp3/Interceptor;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.util.TokenManager tokenManager = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String BASE_URL = "https://lemonchiffon-boar-634911.hostingersite.com/api/";
    @org.jetbrains.annotations.NotNull
    private final okhttp3.logging.HttpLoggingInterceptor loggingInterceptor = null;
    @org.jetbrains.annotations.NotNull
    private final okhttp3.Interceptor authInterceptor = null;
    @org.jetbrains.annotations.NotNull
    private final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy apiService$delegate = null;
    
    @javax.inject.Inject
    public RetrofitClient(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.util.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.libreriaonline.api.ApiService getApiService() {
        return null;
    }
}