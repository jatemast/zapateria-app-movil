package com.example.libreriaonline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libreriaonline.model.LoginRequest
import com.example.libreriaonline.model.LoginResponse
import com.example.libreriaonline.model.RegistroRequest
import com.example.libreriaonline.model.User
import com.example.libreriaonline.model.UserUpdateRequest
import com.example.libreriaonline.model.UserUpdateResponse
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

    private val _userState = MutableStateFlow<AuthResult<User>>(AuthResult.Idle)
    val userState: StateFlow<AuthResult<User>> = _userState

    private val _userUpdateState = MutableStateFlow<AuthResult<UserUpdateResponse>>(AuthResult.Idle)
    val userUpdateState: StateFlow<AuthResult<UserUpdateResponse>> = _userUpdateState

    fun register(request: RegistroRequest) {
        viewModelScope.launch {
            _registrationState.value = AuthResult.Loading
            try {
                val response = repository.register(request)
                if (response.isSuccessful) {
                    _registrationState.value = AuthResult.Success(Unit)
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Error desconocido"
                    _registrationState.value = AuthResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                _registrationState.value = AuthResult.Error(e.localizedMessage ?: "Error de red")
            }
        }
    }

    fun getUser() {
        viewModelScope.launch {
            _userState.value = AuthResult.Loading
            try {
                val response = repository.getUser()
                if (response.isSuccessful && response.body() != null) {
                    _userState.value = AuthResult.Success(response.body()!!)
                } else {
                    _userState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                _userState.value = AuthResult.Error(e.localizedMessage ?: "Error de red")
            }
        }
    }

    fun updateUser(request: UserUpdateRequest) {
        viewModelScope.launch {
            _userUpdateState.value = AuthResult.Loading
            try {
                val response = repository.updateUser(request)
                if (response.isSuccessful && response.body() != null) {
                    _userUpdateState.value = AuthResult.Success(response.body()!!)
                } else {
                    _userUpdateState.value = AuthResult.Error(response.errorBody()?.string() ?: "Error desconocido")
                }
            } catch (e: Exception) {
                _userUpdateState.value = AuthResult.Error(e.localizedMessage ?: "Error de red")
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

    fun logout() {
        viewModelScope.launch {
            repository.logout()
            // No es necesario manejar la respuesta aquí directamente, solo asegurar que el token se elimine.
            // Si la API devuelve un mensaje de éxito, se puede añadir aquí.
        }
    }

    fun resetRegistrationState() {
        _registrationState.value = AuthResult.Idle
    }

    fun resetLoginState() {
        _loginState.value = AuthResult.Idle
    }

    fun resetUserState() {
        _userState.value = AuthResult.Idle
    }

    fun resetUserUpdateState() {
        _userUpdateState.value = AuthResult.Idle
    }
}

sealed class AuthResult<out T> {
    object Idle : AuthResult<Nothing>()
    object Loading : AuthResult<Nothing>()
    data class Success<out T>(val data: T) : AuthResult<T>()
    data class Error(val message: String) : AuthResult<Nothing>()
}