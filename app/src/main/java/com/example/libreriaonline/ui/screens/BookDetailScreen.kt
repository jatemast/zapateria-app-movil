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
import com.example.libreriaonline.AuthResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    navController: NavController,
    bookId: Int,
    bookViewModel: BookViewModel = hiltViewModel()
) {
    val libro by bookViewModel.selectedBook.collectAsState(initial = null)

    LaunchedEffect(bookId) {
        bookViewModel.fetchBook(bookId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    val currentLibroState = libro
                    Text(
                        when (currentLibroState) {
                            is AuthResult.Success -> currentLibroState.data.name
                            else -> "Detalle del Libro"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                    }
                },
                actions = {
                    val currentLibroState = libro
                    if (currentLibroState is AuthResult.Success) {
                        val currentLibro = currentLibroState.data

                        IconButton(onClick = {
                            bookViewModel.setSelectedBook(currentLibro)
                            navController.navigate("book_add_edit/${currentLibro.id}")
                        }) {
                            Icon(Icons.Default.Edit, contentDescription = "Editar")
                        }

                        IconButton(onClick = {
                            bookViewModel.deleteBook(currentLibro.id)
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        val currentLibroState = libro

        when (currentLibroState) {
            is AuthResult.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is AuthResult.Success -> {
                val currentLibro = currentLibroState.data

                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    AsyncImage(
                        model = currentLibro.imageUrl,
                        contentDescription = "Imagen del libro",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Nombre: ${currentLibro.name}",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "Cantidad: ${currentLibro.quantity}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Precio: ${currentLibro.price}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Creado en: ${currentLibro.createdAt ?: "N/A"}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Actualizado en: ${currentLibro.updatedAt ?: "N/A"}",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            is AuthResult.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = "Error al cargar el libro: ${currentLibroState.message}",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            AuthResult.Idle, null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        text = "Cargando detalle del libro...",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}
