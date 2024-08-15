package favorites.client.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import favorites.client.auth.AmplifyService
import kotlinx.coroutines.launch

class AuthViewModel() : ViewModel() {
    private val amplifyService = AmplifyService()

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _authState = mutableStateOf<AuthState>(AuthState.Idle)
    val authState: State<AuthState> = _authState

    private val _code = mutableStateOf("")
    val code: State<String> = _code

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setEmail(value: String) {
        _email.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    fun setCode(value: String) {
        _code.value = value
    }

    fun verifyCode() {
        _authState.value = AuthState.Loading
        amplifyService.verifyCode(_username.value, _code.value) {
            _authState.value = AuthState.Success
        }
    }
    fun setAuthState(value: AuthState){
        _authState.value = value

    }

    fun login() {
        setAuthState(AuthState.Loading)
        amplifyService.login(_username.value, _password.value) { isSuccess, errorMessage ->
            if (isSuccess) {
                viewModelScope.launch {
                    amplifyService.fetchEmailAndLog(onEmailFetched = {
                        setEmail(it)
                        setAuthState(AuthState.Success)
                    })
                }
            } else {
                setAuthState(AuthState.Error(errorMessage ?: "Login failed. Please check your credentials."))
            }
        }
    }

    fun signUp() {
        _authState.value = AuthState.Loading
        amplifyService.signUp(_username.value, _email.value, _password.value) {
            _authState.value = AuthState.Success
        }
    }

    fun logOut() {
        amplifyService.logOut {
            _authState.value = AuthState.Idle
        }
    }

    fun setErrorMessage(message: String?) {
        if (message != null) {
            _authState.value = AuthState.Error(message)
        }
    }
}

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object Success : AuthState()
    data class Error(val message: String) : AuthState()
}
