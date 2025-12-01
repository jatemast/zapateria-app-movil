package com.example.libreriaonline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libreriaonline.model.Libro
import com.example.libreriaonline.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _libros = MutableStateFlow<List<Libro>>(emptyList())
    val libros: StateFlow<List<Libro>> = _libros

    private val _selectedLibro = MutableStateFlow<Libro?>(null)
    val selectedLibro: StateFlow<Libro?> = _selectedLibro

    init {
        fetchLibros()
    }

    fun fetchLibros() {
        viewModelScope.launch {
            _libros.value = bookRepository.getLibros() ?: emptyList()
        }
    }

    fun fetchLibro(id: Int) {
        viewModelScope.launch {
            _selectedLibro.value = bookRepository.getLibro(id)
        }
    }

    fun createLibro(libro: Libro) {
        viewModelScope.launch {
            bookRepository.createLibro(libro)
            fetchLibros()
        }
    }

    fun updateLibro(id: Int, libro: Libro) {
        viewModelScope.launch {
            bookRepository.updateLibro(id, libro)
            fetchLibros()
        }
    }

    fun deleteLibro(id: Int) {
        viewModelScope.launch {
            bookRepository.deleteLibro(id)
            fetchLibros()
        }
    }

    fun setSelectedLibro(libro: Libro?) {
        _selectedLibro.value = libro
    }
}