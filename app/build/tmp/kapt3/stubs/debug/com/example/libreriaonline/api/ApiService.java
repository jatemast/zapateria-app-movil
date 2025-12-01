package com.example.libreriaonline.api;

import com.example.libreriaonline.model.BookCreateRequest;
import com.example.libreriaonline.model.Libro;
import com.example.libreriaonline.model.LoginRequest;
import com.example.libreriaonline.model.LoginResponse;
import com.example.libreriaonline.model.RegistroRequest;
import com.example.libreriaonline.model.User;
import com.example.libreriaonline.model.UserUpdateRequest;
import com.example.libreriaonline.model.UserUpdateResponse;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J-\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00180\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u001cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\'\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u0019H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J+\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J!\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010\u0005\u001a\u00020%H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/libreriaonline/api/ApiService;", "", "createBook", "Lretrofit2/Response;", "Lcom/example/libreriaonline/model/Libro;", "request", "Lcom/example/libreriaonline/model/BookCreateRequest;", "(Lcom/example/libreriaonline/model/BookCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLibro", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLibro", "getLibros", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/example/libreriaonline/model/User;", "login", "Lcom/example/libreriaonline/model/LoginResponse;", "Lcom/example/libreriaonline/model/LoginRequest;", "(Lcom/example/libreriaonline/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "", "purchaseLibro", "register", "Lcom/example/libreriaonline/model/RegistroRequest;", "(Lcom/example/libreriaonline/model/RegistroRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchLibros", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBook", "(ILcom/example/libreriaonline/model/BookCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "Lcom/example/libreriaonline/model/UserUpdateResponse;", "Lcom/example/libreriaonline/model/UserUpdateRequest;", "(Lcom/example/libreriaonline/model/UserUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
    
    @retrofit2.http.GET(value = "books")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLibros(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.libreriaonline.model.Libro>>> $completion);
    
    @retrofit2.http.GET(value = "books/search")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object searchLibros(@retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.libreriaonline.model.Libro>>> $completion);
    
    @retrofit2.http.GET(value = "books/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLibro(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.POST(value = "books")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createBook(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.BookCreateRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.PUT(value = "books/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBook(@retrofit2.http.Path(value = "id")
    int id, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.BookCreateRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.Libro>> $completion);
    
    @retrofit2.http.DELETE(value = "books/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteLibro(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "books/{id}/purchase")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object purchaseLibro(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
    
    @retrofit2.http.POST(value = "logout")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
    
    @retrofit2.http.GET(value = "user")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.User>> $completion);
    
    @retrofit2.http.PUT(value = "user")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUser(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.UserUpdateRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.libreriaonline.model.UserUpdateResponse>> $completion);
}