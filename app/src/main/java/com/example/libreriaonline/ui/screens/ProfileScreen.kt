package com.example.libreriaonline.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libreriaonline.AuthResult
import com.example.libreriaonline.AuthViewModel
import com.example.libreriaonline.model.UserUpdateRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, authViewModel: AuthViewModel = hiltViewModel()) {
    val userState by authViewModel.userState.collectAsState()
    val userUpdateState by authViewModel.userUpdateState.collectAsState()
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        authViewModel.getUser()
    }

    LaunchedEffect(userState) {
        when (userState) {
            is AuthResult.Success -> {
                val user = (userState as AuthResult.Success).data
                name = user.name
                email = user.email
            }
            is AuthResult.Error -> {
                val errorMessage = (userState as AuthResult.Error).message
                Toast.makeText(context, "Error al cargar perfil: $errorMessage", Toast.LENGTH_LONG).show()
                authViewModel.resetUserState() // Resetear solo en caso de error
            }
            else -> {}
        }
    }

    LaunchedEffect(userUpdateState) {
        when (userUpdateState) {
            is AuthResult.Success -> {
                Toast.makeText(context, "Perfil actualizado con éxito", Toast.LENGTH_SHORT).show()
                authViewModel.resetUserUpdateState()
                authViewModel.getUser() // Recargar los datos del usuario después de una actualización exitosa
            }
            is AuthResult.Error -> {
                val errorMessage = (userUpdateState as AuthResult.Error).message
                Toast.makeText(context, "Error al actualizar perfil: $errorMessage", Toast.LENGTH_LONG).show()
                authViewModel.resetUserUpdateState()
            }
            else -> {}
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Perfil de Usuario", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                authViewModel.updateUser(UserUpdateRequest(name, email))
            },
            enabled = userUpdateState != AuthResult.Loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (userUpdateState is AuthResult.Loading) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
            } else {
                Text("Actualizar Perfil")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}