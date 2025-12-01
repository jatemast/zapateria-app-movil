package com.example.libreriaonline;

import androidx.lifecycle.ViewModel;
import com.example.libreriaonline.model.LoginRequest;
import com.example.libreriaonline.model.LoginResponse;
import com.example.libreriaonline.model.RegistroRequest;
import com.example.libreriaonline.model.User;
import com.example.libreriaonline.model.UserUpdateRequest;
import com.example.libreriaonline.model.UserUpdateResponse;
import com.example.libreriaonline.repository.AuthRepository;
import kotlinx.coroutines.flow.StateFlow;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020%R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/example/libreriaonline/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/libreriaonline/repository/AuthRepository;", "(Lcom/example/libreriaonline/repository/AuthRepository;)V", "_loginState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/libreriaonline/AuthResult;", "Lcom/example/libreriaonline/model/LoginResponse;", "_registrationState", "", "_userState", "Lcom/example/libreriaonline/model/User;", "_userUpdateState", "Lcom/example/libreriaonline/model/UserUpdateResponse;", "loginState", "Lkotlinx/coroutines/flow/StateFlow;", "getLoginState", "()Lkotlinx/coroutines/flow/StateFlow;", "registrationState", "getRegistrationState", "userState", "getUserState", "userUpdateState", "getUserUpdateState", "getUser", "login", "request", "Lcom/example/libreriaonline/model/LoginRequest;", "logout", "register", "Lcom/example/libreriaonline/model/RegistroRequest;", "resetLoginState", "resetRegistrationState", "resetUserState", "resetUserUpdateState", "updateUser", "Lcom/example/libreriaonline/model/UserUpdateRequest;", "app_debug"})
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
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.User>> _userState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.User>> userState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.UserUpdateResponse>> _userUpdateState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.UserUpdateResponse>> userUpdateState = null;
    
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
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.User>> getUserState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.libreriaonline.AuthResult<com.example.libreriaonline.model.UserUpdateResponse>> getUserUpdateState() {
        return null;
    }
    
    public final void register(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.RegistroRequest request) {
    }
    
    public final void getUser() {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.UserUpdateRequest request) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull
    com.example.libreriaonline.model.LoginRequest request) {
    }
    
    public final void logout() {
    }
    
    public final void resetRegistrationState() {
    }
    
    public final void resetLoginState() {
    }
    
    public final void resetUserState() {
    }
    
    public final void resetUserUpdateState() {
    }
}