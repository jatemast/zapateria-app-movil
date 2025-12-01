package com.example.libreriaonline;

import androidx.lifecycle.ViewModel;
import com.example.libreriaonline.model.Libro;
import com.example.libreriaonline.repository.BookRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0011J\u0010\u0010\u0018\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/example/libreriaonline/BookViewModel;", "Landroidx/lifecycle/ViewModel;", "bookRepository", "Lcom/example/libreriaonline/repository/BookRepository;", "(Lcom/example/libreriaonline/repository/BookRepository;)V", "_libros", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/libreriaonline/model/Libro;", "_selectedLibro", "libros", "Lkotlinx/coroutines/flow/StateFlow;", "getLibros", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedLibro", "getSelectedLibro", "createLibro", "", "libro", "deleteLibro", "id", "", "fetchLibro", "fetchLibros", "setSelectedLibro", "updateLibro", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class BookViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.repository.BookRepository bookRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.libreriaonline.model.Libro>> _libros = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.libreriaonline.model.Libro>> libros = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.model.Libro> _selectedLibro = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.model.Libro> selectedLibro = null;
    
    @javax.inject.Inject
    public BookViewModel(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.repository.BookRepository bookRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.libreriaonline.model.Libro>> getLibros() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.model.Libro> getSelectedLibro() {
        return null;
    }
    
    public final void fetchLibros() {
    }
    
    public final void fetchLibro(int id) {
    }
    
    public final void createLibro(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro) {
    }
    
    public final void updateLibro(int id, @org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.Libro libro) {
    }
    
    public final void deleteLibro(int id) {
    }
    
    public final void setSelectedLibro(@org.jetbrains.annotations.Nullable
    com.example.libreriaonline.model.Libro libro) {
    }
}