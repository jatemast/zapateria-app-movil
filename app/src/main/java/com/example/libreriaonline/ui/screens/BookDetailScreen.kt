package com.example.libreriaonline.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.libreriaonline.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    navController: NavController,
    bookId: Int,
    bookViewModel: BookViewModel = hiltViewModel()
) {
    val libro by bookViewModel.selectedLibro.collectAsState()

    LaunchedEffect(bookId) {
        bookViewModel.fetchLibro(bookId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(libro?.titulo ?: "Detalle del Libro") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                },
                actions = {
                    libro?.let {
                        IconButton(onClick = {
                            bookViewModel.setSelectedLibro(it) // Set for editing
                            navController.navigate("book_add_edit/${it.id}")
                        }) {
                            Icon(Icons.Default.Edit, contentDescription = "Editar")
                        }
                        IconButton(onClick = {
                            bookViewModel.deleteLibro(it.id)
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        libro?.let {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = it.imagen,
                    contentDescription = "Imagen del libro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Título: ${it.titulo}", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Autor ID: ${it.autorId}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Categoría ID: ${it.categoriaId}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "ISBN: ${it.isbn}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Editorial: ${it.editorial}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Precio: ${it.precio}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Stock: ${it.stock}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Fecha Publicación: ${it.fechaPublicacion}", style = MaterialTheme.typography.bodyLarge)
                it.descripcion?.let { desc ->
                    Text(text = "Descripción: $desc", style = MaterialTheme.typography.bodyLarge)
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}