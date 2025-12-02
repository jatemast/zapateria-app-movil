package com.example.libreriaonline.ui.screens

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.libreriaonline.AuthResult
import com.example.libreriaonline.AuthViewModel
import com.example.libreriaonline.model.RegistroRequest
import com.google.android.gms.location.LocationServices

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController, authViewModel: AuthViewModel = hiltViewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirmation by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("0.0") }
    var longitude by remember { mutableStateOf("0.0") }
    val registrationState by authViewModel.registrationState.collectAsState()
    val context = LocalContext.current
    val webView = remember { WebView(context) }
    val webAppInterface = remember {
        WebAppInterface(context) { lat, lng ->
            latitude = lat.toString()
            longitude = lng.toString()
        }
    }

    // Permisos de ubicación
    val locationPermissionsGranted = remember { mutableStateOf(false) }
    var initialLocationSet by remember { mutableStateOf(false) }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        locationPermissionsGranted.value = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        if (!locationPermissionsGranted.value) {
            Toast.makeText(context, "Permisos de ubicación denegados", Toast.LENGTH_SHORT).show()
        }
    }

    // Solicitar permisos y obtener la última ubicación
    LaunchedEffect(locationPermissionsGranted.value) {
        if (locationPermissionsGranted.value && !initialLocationSet) {
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    latitude = it.latitude.toString()
                    longitude = it.longitude.toString()
                    // Si el WebView ya está cargado, actualiza la ubicación
                    if (webView.url?.contains("leaflet_map.html") == true) {
                        webView.evaluateJavascript("setInitialLocation(${it.latitude}, ${it.longitude});", null)
                    }
                    initialLocationSet = true
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        when {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                locationPermissionsGranted.value = true
            }
            else -> {
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }

    LaunchedEffect(registrationState) {
        when (registrationState) {
            is AuthResult.Success -> {
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                authViewModel.resetRegistrationState()
                navController.popBackStack() // Volver a la pantalla de login
            }
            is AuthResult.Error -> {
                val errorMessage = (registrationState as AuthResult.Error).message
                Toast.makeText(context, "Error en el registro: $errorMessage", Toast.LENGTH_LONG).show()
                authViewModel.resetRegistrationState()
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
        Text("Registro", style = MaterialTheme.typography.headlineMedium)
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = passwordConfirmation,
            onValueChange = { passwordConfirmation = it },
            label = { Text("Confirmar Contraseña") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Confirmar Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Mapa para seleccionar ubicación (Leaflet a través de WebView)
        Text("Selecciona tu ubicación:", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        if (locationPermissionsGranted.value) {
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                factory = {
                    webView.apply {
                        settings.javaScriptEnabled = true
                        webViewClient = object : WebViewClient() {
                            override fun onReceivedError(
                                view: WebView?,
                                errorCode: Int,
                                description: String?,
                                failingUrl: String?
                            ) {
                                Toast.makeText(context, "Error cargando el mapa: $description", Toast.LENGTH_LONG).show()
                            }

                            override fun onPageFinished(view: WebView?, url: String?) {
                                super.onPageFinished(view, url)
                                if (url?.contains("leaflet_map.html") == true && initialLocationSet) {
                                    view?.evaluateJavascript("setInitialLocation($latitude, $longitude);", null)
                                }
                            }
                        }
                        webChromeClient = object : android.webkit.WebChromeClient() {
                            override fun onConsoleMessage(consoleMessage: android.webkit.ConsoleMessage?): Boolean {
                                android.util.Log.d("WebViewConsole", "${consoleMessage?.message()} -- From line ${consoleMessage?.lineNumber()} of ${consoleMessage?.sourceId()}")
                                return super.onConsoleMessage(consoleMessage)
                            }
                        }
                        addJavascriptInterface(webAppInterface, "Android")
                        loadUrl("file:///android_asset/leaflet_map.html")
                        WebView.setWebContentsDebuggingEnabled(true)
                    }
                },
                update = {
                    // No es necesario actualizar el WebView aquí, ya que el estado se maneja a través de JavascriptInterface
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Latitud: $latitude, Longitud: $longitude")
            Spacer(modifier = Modifier.height(16.dp))
        } else {
            Text("Permisos de ubicación no concedidos. No se puede mostrar el mapa.")
            Spacer(modifier = Modifier.height(16.dp))
        }

        Button(
            onClick = {
                if (password == passwordConfirmation) {
                    val request = RegistroRequest(
                        name,
                        email,
                        password,
                        passwordConfirmation,
                        latitude,
                        longitude
                    )
                    authViewModel.register(request)
                } else {
                    Toast.makeText(context, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            },
            enabled = registrationState != AuthResult.Loading,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (registrationState is AuthResult.Loading) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
            } else {
                Text("Registrarse")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { navController.popBackStack() }) {
            Text("¿Ya tienes una cuenta? Inicia sesión")
        }
    }
}

class WebAppInterface(private val mContext: Context, private val onMapClickListener: (Double, Double) -> Unit) {
    @JavascriptInterface
    fun onMapClick(lat: Double, lng: Double) {
        onMapClickListener(lat, lng)
    }
}