package com.example.libreriaonline.repository

import com.example.libreriaonline.api.ApiService
import com.example.libreriaonline.model.BookCreateRequest
import com.example.libreriaonline.model.Libro
import javax.inject.Inject
import javax.inject.Singleton
import retrofit2.Response

@Singleton
class BookRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLibros(): Response<List<Libro>> {
        return apiService.getLibros()
    }

    suspend fun searchLibros(query: String): Response<List<Libro>> {
        return apiService.searchLibros(query)
    }

    suspend fun getLibro(id: Int): Response<Libro> {
        return apiService.getLibro(id)
    }

    suspend fun createBook(request: BookCreateRequest): Response<Libro> {
        return apiService.createBook(request)
    }

    suspend fun updateBook(id: Int, request: BookCreateRequest): Response<Libro> {
        return apiService.updateBook(id, request)
    }

    suspend fun deleteLibro(id: Int): Response<Unit> {
        return apiService.deleteLibro(id)
    }

    suspend fun purchaseLibro(id: Int): Response<Map<String, String>> {
        return apiService.purchaseLibro(id)
    }
}