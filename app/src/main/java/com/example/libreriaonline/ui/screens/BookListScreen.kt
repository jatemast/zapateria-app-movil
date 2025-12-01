package com.example.libreriaonline.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libreriaonline.BookViewModel
import com.example.libreriaonline.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    navController: NavController,
    bookViewModel: BookViewModel = hiltViewModel()
) {
    val libros by bookViewModel.libros.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Libros") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("book_add_edit") }) {
                Icon(Icons.Default.Add, contentDescription = "Añadir libro")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(libros) { libro ->
                BookListItem(libro = libro) {
                    bookViewModel.setSelectedLibro(libro)
                    navController.navigate("book_detail/${libro.id}")
                }
            }
        }
    }
}

@Composable
fun BookListItem(libro: Libro, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = libro.titulo, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "ISBN: ${libro.isbn}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}