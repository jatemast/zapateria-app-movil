package com.example.libreriaonline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libreriaonline.model.LoginRequest
import com.example.libreriaonline.model.LoginResponse
import com.example.libreriaonline.model.RegistroRequest
import com.example.libreriaonline.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
 
 @HiltViewModel
 class AuthViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {
 
     private val _registrationState = MutableStateFlow<AuthResult<Unit>> (AuthResult.Idle)
    val registrationState: StateFlow<AuthResult<Unit>> = _registrationState

    private val _loginState = MutableStateFlow<AuthResult<LoginResponse>> (AuthResult.Idle)
    val loginState: StateFlow<AuthResult<LoginResponse>> = _loginState

    fun register(request: RegistroRequest) {
        viewModelScope.launch {
            _registrationState.value = AuthResult.Loading
            try {
                val response = repository.register(request)
                if (response.isSuccessful) {
                    _registrationState.value = AuthResult.Success(Unit)
                } else {
                    _registrationState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                _registrationState.value = AuthResult.Error(e.localizedMessage ?: "Error de red")
            }
        }
    }

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            _loginState.value = AuthResult.Loading
            try {
                val response = repository.login(request)
                if (response.isSuccessful && response.body() != null) {
                    _loginState.value = AuthResult.Success(response.body()!!)
                } else {
                    _loginState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                _loginState.value = AuthResult.Error(e.localizedMessage ?: "Error de red")
            }
        }
    }

    fun resetRegistrationState() {
        _registrationState.value = AuthResult.Idle
    }

    fun resetLoginState() {
        _loginState.value = AuthResult.Idle
    }
}

sealed class AuthResult<out T> {
    object Idle : AuthResult<Nothing>()
    object Loading : AuthResult<Nothing>()
    data class Success<out T>(val data: T) : AuthResult<T>()
    data class Error(val message: String) : AuthResult<Nothing>()
}