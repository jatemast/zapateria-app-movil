package com.example.libreriaonline.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.libreriaonline.BookViewModel

@Composable
fun BookAddEditScreen(
    navController: NavController,
    bookId: Int?,
    bookViewModel: BookViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Book Add/Edit Screen for ID: ${bookId ?: "New Book"}")
    }
}