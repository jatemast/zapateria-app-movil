package com.example.libreriaonline;

import androidx.lifecycle.ViewModel;
import com.example.libreriaonline.model.BookCreateRequest;
import com.example.libreriaonline.model.Libro;
import com.example.libreriaonline.repository.BookRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import com.example.libreriaonline.AuthResult;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\bJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\rJ\u0010\u0010&\u001a\u00020\b2\b\u0010\'\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/example/libreriaonline/BookViewModel;", "Landroidx/lifecycle/ViewModel;", "bookRepository", "Lcom/example/libreriaonline/repository/BookRepository;", "(Lcom/example/libreriaonline/repository/BookRepository;)V", "_bookOperationState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/libreriaonline/AuthResult;", "", "_books", "", "Lcom/example/libreriaonline/model/Libro;", "_purchaseState", "", "_selectedBook", "bookOperationState", "Lkotlinx/coroutines/flow/StateFlow;", "getBookOperationState", "()Lkotlinx/coroutines/flow/StateFlow;", "books", "getBooks", "purchaseState", "getPurchaseState", "selectedBook", "getSelectedBook", "createBook", "request", "Lcom/example/libreriaonline/model/BookCreateRequest;", "deleteBook", "id", "", "fetchBook", "fetchBooks", "purchaseBook", "resetBookOperationState", "resetPurchaseState", "searchBooks", "query", "setSelectedBook", "libro", "updateBook", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class BookViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.repository.BookRepository bookRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<java.util.List<com.example.libreriaonline.model.Libro>>> _books = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<java.util.List<com.example.libreriaonline.model.Libro>>> books = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.Libro>> _selectedBook = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.Libro>> selectedBook = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> _bookOperationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> bookOperationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<java.lang.String>> _purchaseState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<java.lang.String>> purchaseState = null;
    
    @javax.inject.Inject
    public BookViewModel(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.repository.BookRepository bookRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<java.util.List<com.example.libreriaonline.model.Libro>>> getBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.Libro>> getSelectedBook() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> getBookOperationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<java.lang.String>> getPurchaseState() {
        return null;
    }
    
    public final void fetchBooks() {
    }
    
    public final void searchBooks(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void fetchBook(int id) {
    }
    
    public final void setSelectedBook(@org.jetbrains.annotations.Nullable
    com.example.libreriaonline.model.Libro libro) {
    }
    
    public final void createBook(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.BookCreateRequest request) {
    }
    
    public final void updateBook(int id, @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.BookCreateRequest request) {
    }
    
    public final void deleteBook(int id) {
    }
    
    public final void purchaseBook(int id) {
    }
    
    public final void resetBookOperationState() {
    }
    
    public final void resetPurchaseState() {
    }
}