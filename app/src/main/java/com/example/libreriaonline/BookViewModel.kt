package com.example.libreriaonline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libreriaonline.model.BookCreateRequest
import com.example.libreriaonline.model.Libro
import com.example.libreriaonline.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.libreriaonline.AuthResult // Reutilizar AuthResult para operaciones de libros

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _books = MutableStateFlow<AuthResult<List<Libro>>>(AuthResult.Idle)
    val books: StateFlow<AuthResult<List<Libro>>> = _books

    private val _selectedBook = MutableStateFlow<AuthResult<Libro>>(AuthResult.Idle)
    val selectedBook: StateFlow<AuthResult<Libro>> = _selectedBook

    private val _bookOperationState = MutableStateFlow<AuthResult<Unit>>(AuthResult.Idle)
    val bookOperationState: StateFlow<AuthResult<Unit>> = _bookOperationState

    private val _purchaseState = MutableStateFlow<AuthResult<String>>(AuthResult.Idle)
    val purchaseState: StateFlow<AuthResult<String>> = _purchaseState

    init {
        fetchBooks()
    }

    fun fetchBooks() {
        viewModelScope.launch {
            _books.value = AuthResult.Loading
            try {
                val response = bookRepository.getLibros()
                if (response.isSuccessful && response.body() != null) {
                    _books.value = AuthResult.Success(response.body()!!)
                } else {
                    _books.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al cargar libros")
                }
            } catch (e: Exception) {
                _books.value = AuthResult.Error(e.localizedMessage ?: "Error de red al cargar libros")
            }
        }
    }

    fun searchBooks(query: String) {
        viewModelScope.launch {
            _books.value = AuthResult.Loading
            try {
                val response = bookRepository.searchLibros(query)
                if (response.isSuccessful && response.body() != null) {
                    _books.value = AuthResult.Success(response.body()!!)
                } else {
                    _books.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al buscar libros")
                }
            } catch (e: Exception) {
                _books.value = AuthResult.Error(e.localizedMessage ?: "Error de red al buscar libros")
            }
        }
    }

    fun fetchBook(id: Int) {
        viewModelScope.launch {
            _selectedBook.value = AuthResult.Loading
            try {
                val response = bookRepository.getLibro(id)
                if (response.isSuccessful && response.body() != null) {
                    _selectedBook.value = AuthResult.Success(response.body()!!)
                } else {
                    _selectedBook.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al cargar libro")
                }
            } catch (e: Exception) {
                _selectedBook.value = AuthResult.Error(e.localizedMessage ?: "Error de red al cargar libro")
            }
        }
    }

    fun setSelectedBook(libro: Libro?) {
        _selectedBook.value = if (libro == null) AuthResult.Idle else AuthResult.Success(libro)
    }

    fun createBook(request: BookCreateRequest) {
        viewModelScope.launch {
            _bookOperationState.value = AuthResult.Loading
            try {
                val response = bookRepository.createBook(request)
                if (response.isSuccessful) {
                    _bookOperationState.value = AuthResult.Success(Unit)
                    fetchBooks()
                } else {
                    _bookOperationState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al crear libro")
                }
            } catch (e: Exception) {
                _bookOperationState.value = AuthResult.Error(e.localizedMessage ?: "Error de red al crear libro")
            }
        }
    }

    fun updateBook(id: Int, request: BookCreateRequest) {
        viewModelScope.launch {
            _bookOperationState.value = AuthResult.Loading
            try {
                val response = bookRepository.updateBook(id, request)
                if (response.isSuccessful) {
                    _bookOperationState.value = AuthResult.Success(Unit)
                    fetchBooks()
                } else {
                    _bookOperationState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al actualizar libro")
                }
            } catch (e: Exception) {
                _bookOperationState.value = AuthResult.Error(e.localizedMessage ?: "Error de red al actualizar libro")
            }
        }
    }

    fun deleteBook(id: Int) {
        viewModelScope.launch {
            _bookOperationState.value = AuthResult.Loading
            try {
                val response = bookRepository.deleteLibro(id)
                if (response.isSuccessful) {
                    _bookOperationState.value = AuthResult.Success(Unit)
                    fetchBooks()
                } else {
                    _bookOperationState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al eliminar libro")
                }
            } catch (e: Exception) {
                _bookOperationState.value = AuthResult.Error(e.localizedMessage ?: "Error de red al eliminar libro")
            }
        }
    }

    fun purchaseBook(id: Int) {
        viewModelScope.launch {
            _purchaseState.value = AuthResult.Loading
            try {
                val response = bookRepository.purchaseLibro(id)
                if (response.isSuccessful && response.body() != null) {
                    _purchaseState.value = AuthResult.Success(response.body()!!["message"] ?: "Compra realizada")
                } else {
                    _purchaseState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido al comprar libro")
                }
            } catch (e: Exception) {
                _purchaseState.value = AuthResult.Error(e.localizedMessage ?: "Error de red al comprar libro")
            }
        }
    }

    fun resetBookOperationState() {
        _bookOperationState.value = AuthResult.Idle
    }

    fun resetPurchaseState() {
        _purchaseState.value = AuthResult.Idle
    }
}