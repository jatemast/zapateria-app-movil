package com.example.libreriaonline.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libreriaonline.BookViewModel
import com.example.libreriaonline.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookAddEditScreen(
    navController: NavController,
    bookId: Int? = null,
    bookViewModel: BookViewModel = hiltViewModel()
) {
    val libroToEdit by bookViewModel.selectedLibro.collectAsState()

    var titulo by remember { mutableStateOf("") }
    var autorId by remember { mutableStateOf("") }
    var categoriaId by remember { mutableStateOf("") }
    var isbn by remember { mutableStateOf("") }
    var editorial by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var fechaPublicacion by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }

    LaunchedEffect(bookId) {
        if (bookId != null) {
            bookViewModel.fetchLibro(bookId)
        } else {
            bookViewModel.setSelectedLibro(null) // Clear selected book for add operation
        }
    }

    LaunchedEffect(libroToEdit) {
        libroToEdit?.let {
            titulo = it.titulo
            autorId = it.autorId.toString()
            categoriaId = it.categoriaId.toString()
            isbn = it.isbn
            editorial = it.editorial
            precio = it.precio.toString()
            stock = it.stock.toString()
            fechaPublicacion = it.fechaPublicacion
            descripcion = it.descripcion ?: ""
            imagen = it.imagen ?: ""
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (bookId == null) "Añadir Libro" else "Editar Libro") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = autorId,
                onValueChange = { autorId = it },
                label = { Text("Autor ID") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = categoriaId,
                onValueChange = { categoriaId = it },
                label = { Text("Categoría ID") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = isbn,
                onValueChange = { isbn = it },
                label = { Text("ISBN") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = editorial,
                onValueChange = { editorial = it },
                label = { Text("Editorial") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = stock,
                onValueChange = { stock = it },
                label = { Text("Stock") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = fechaPublicacion,
                onValueChange = { fechaPublicacion = it },
                label = { Text("Fecha de Publicación (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = imagen,
                onValueChange = { imagen = it },
                label = { Text("URL de la Imagen") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    val currentLibro = Libro(
                        id = bookId ?: 0, // ID will be ignored for new books
                        titulo = titulo,
                        autorId = autorId.toIntOrNull() ?: 0,
                        categoriaId = categoriaId.toIntOrNull() ?: 0,
                        isbn = isbn,
                        editorial = editorial,
                        precio = precio.toDoubleOrNull() ?: 0.0,
                        stock = stock.toIntOrNull() ?: 0,
                        fechaPublicacion = fechaPublicacion,
                        descripcion = descripcion.ifEmpty { null },
                        imagen = imagen.ifEmpty { null }
                    )
                    if (bookId == null) {
                        bookViewModel.createLibro(currentLibro)
                    } else {
                        bookViewModel.updateLibro(bookId, currentLibro)
                    }
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (bookId == null) "Añadir Libro" else "Guardar Cambios")
            }
        }
    }
}