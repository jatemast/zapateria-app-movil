package com.example.libreriaonline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.libreriaonline.ui.screens.BookAddEditScreen
import com.example.libreriaonline.ui.screens.BookDetailScreen
import com.example.libreriaonline.ui.screens.BookListScreen
import com.example.libreriaonline.ui.screens.LoginScreen
import com.example.libreriaonline.ui.screens.ProfileScreen
import com.example.libreriaonline.ui.screens.RegisterScreen
import com.example.libreriaonline.ui.theme.LibreriaOnlineAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibreriaOnlineAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "login") { // Cambiado a "login" para autenticación
        composable("login") {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("register") {
            RegisterScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("book_list") {
            BookListScreen(navController = navController, bookViewModel = hiltViewModel())
        }
        composable("profile") {
            ProfileScreen(navController = navController, authViewModel = authViewModel)
        }
        composable(
            "book_detail/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            if (bookId != null) {
                BookDetailScreen(navController = navController, bookId = bookId, bookViewModel = hiltViewModel())
            }
        }
        composable(
            "book_add_edit/{bookId}",
            arguments = listOf(navArgument("bookId") {
                type = NavType.IntType
                defaultValue = -1 // Indicador para "nuevo libro"
            })
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt("bookId")
            BookAddEditScreen(
                navController = navController,
                bookId = if (bookId == -1) null else bookId,
                bookViewModel = hiltViewModel()
            )
        }
        composable("book_add_edit") { // Ruta sin ID para añadir
            BookAddEditScreen(navController = navController, bookViewModel = hiltViewModel())
        }
    }
}