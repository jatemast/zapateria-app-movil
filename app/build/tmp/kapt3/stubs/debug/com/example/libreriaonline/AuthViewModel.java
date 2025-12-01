package com.example.libreriaonline;

import androidx.lifecycle.ViewModel;
import com.example.libreriaonline.model.LoginRequest;
import com.example.libreriaonline.model.LoginResponse;
import com.example.libreriaonline.model.RegistroRequest;
import com.example.libreriaonline.repository.AuthRepository;
import kotlinx.coroutines.flow.StateFlow;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\nR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/libreriaonline/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/libreriaonline/repository/AuthRepository;", "(Lcom/example/libreriaonline/repository/AuthRepository;)V", "_loginState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/libreriaonline/AuthResult;", "Lcom/example/libreriaonline/model/LoginResponse;", "_registrationState", "", "loginState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginState", "()Lkotlinx/coroutines/flow/StateFlow;", "registrationState", "getRegistrationState", "login", "request", "Lcom/example/libreriaonline/model/LoginRequest;", "register", "Lcom/example/libreriaonline/model/RegistroRequest;", "resetLoginState", "resetRegistrationState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.libreriaonline.repository.AuthRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> _registrationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> registrationState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.LoginResponse>> _loginState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.LoginResponse>> loginState = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.repository.AuthRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<kotlin.Unit>> getRegistrationState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.LoginResponse>> getLoginState() {
        return null;
    }
    
    public final void register(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.RegistroRequest request) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.LoginRequest request) {
    }
    
    public final void resetRegistrationState() {
    }
    
    public final void resetLoginState() {
    }
}