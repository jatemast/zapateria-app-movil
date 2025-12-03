package com.example.libreriaonline.ui.screens

import com.example.libreriaonline.AuthResult
import com.example.libreriaonline.AuthViewModel
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.libreriaonline.BookViewModel
import com.example.libreriaonline.model.Libro
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    navController: NavController,
    bookViewModel: BookViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val bookListResult by bookViewModel.books.collectAsState()
    val libros = if (bookListResult is AuthResult.Success) (bookListResult as AuthResult.Success).data else emptyList()
    val purchaseState by bookViewModel.purchaseState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(purchaseState) {
        when (purchaseState) {
            is AuthResult.Success -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Compra exitosa: ${(purchaseState as AuthResult.Success).data}")
                }
                bookViewModel.resetPurchaseState()
            }
            is AuthResult.Error -> {
                scope.launch {
                    snackbarHostState.showSnackbar("Error al comprar: ${(purchaseState as AuthResult.Error).message}")
                }
                bookViewModel.resetPurchaseState()
            }
            else -> {}
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Libros") },
                actions = {
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Perfil")
                    }
                    IconButton(onClick = {
                        authViewModel.logout()
                        navController.navigate("login") {
                            popUpTo("book_list") { inclusive = true }
                        }
                    }) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión")
                    }
                }
            )
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(libros) { libro ->
                BookListItem(libro = libro, bookViewModel = bookViewModel) {
                    bookViewModel.setSelectedBook(libro)
                    navController.navigate("book_detail/${libro.id}")
                }
            }
        }
    }
}

@Composable
fun BookListItem(libro: Libro, bookViewModel: BookViewModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = libro.imageUrl,
                contentDescription = "Imagen del libro: ${libro.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // Ajusta la altura según sea necesario
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = libro.name, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Cantidad: ${libro.quantity}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Precio: ${libro.price}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { bookViewModel.purchaseBook(libro.id) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Comprar")
            }
        }
    }
}