package com.example.libreriaonline.repository;

import com.example.libreriaonline.api.ApiService;
import com.example.libreriaonline.model.Libro;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/libreriaonline/repository/BookRepository;", "", "apiService", "Lcom/example/libreriaonline/api/ApiService;", "(Lcom/example/libreriaonline/api/ApiService;)V", "createLibro", "Lcom/example/libreriaonline/model/Libro;", "libro", "(Lcom/example/libreriaonline/model/Libro;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLibro", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLibro", "getLibros", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLibro", "(ILcom/example/libreriaonline/model/Libro;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class BookRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.api.ApiService apiService = null;
    
    @javax.inject.Inject
    public BookRepository(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.api.ApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLibros(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.libreriaonline.model.Libro>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLibro(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.libreriaonline.model.Libro> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createLibro(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.libreriaonline.model.Libro> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLibro(int id, @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.libreriaonline.model.Libro> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteLibro(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}