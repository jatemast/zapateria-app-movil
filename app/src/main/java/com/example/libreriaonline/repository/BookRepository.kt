package com.example.libreriaonline.repository

import com.example.libreriaonline.api.ApiService
import com.example.libreriaonline.model.Libro
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getLibros(): List<Libro>? {
        return try {
            val response = apiService.getLibros()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getLibro(id: Int): Libro? {
        return try {
            val response = apiService.getLibro(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun createLibro(libro: Libro): Libro? {
        return try {
            val response = apiService.createLibro(libro)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun updateLibro(id: Int, libro: Libro): Libro? {
        return try {
            val response = apiService.updateLibro(id, libro)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun deleteLibro(id: Int): Boolean {
        return try {
            val response = apiService.deleteLibro(id)
            response.isSuccessful
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}