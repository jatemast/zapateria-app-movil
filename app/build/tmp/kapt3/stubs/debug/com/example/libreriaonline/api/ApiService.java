package com.example.libreriaonline.api;

import com.example.libreriaonline.model.Libro;
import com.example.libreriaonline.model.LoginRequest;
import com.example.libreriaonline.model.LoginResponse;
import com.example.libreriaonline.model.RegistroRequest;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0016H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/example/libreriaonline/api/ApiService;", "", "createLibro", "Lretrofit2/Response;", "Lcom/example/libreriaonline/model/Libro;", "libro", "(Lcom/example/libreriaonline/model/Libro;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLibro", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLibro", "getLibros", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/example/libreriaonline/model/LoginResponse;", "request", "Lcom/example/libreriaonline/model/LoginRequest;", "(Lcom/example/libreriaonline/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Lcom/example/libreriaonline/model/RegistroRequest;", "(Lcom/example/libreriaonline/model/RegistroRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLibro", "(ILcom/example/libreriaonline/model/Libro;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.RegistroRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.LoginRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.LoginResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/libros")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLibros(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.libreriaonline.model.Libro>>> $completion);
    
    @retrofit2.http.GET(value = "api/libros/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLibro(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.POST(value = "api/libros")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createLibro(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.PUT(value = "api/libros/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateLibro(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.DELETE(value = "api/libros/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteLibro(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
}