package favorites.client.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import favorites.client.auth.AmplifyService
import kotlinx.coroutines.launch

class AuthViewModel(private val amplifyService: AmplifyService) : ViewModel() {

    private val _username = mutableStateOf("")
    val username: State<String> = _username

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _authState = mutableStateOf<AuthState>(AuthState.Idle)
    val authState: State<AuthState> = _authState

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setEmail(value: String) {
        _email.value = value
    }

    fun setPassword(value: String) {
        _password.value = value
    }

    fun login() {
        _authState.value = AuthState.Loading
        amplifyService.login(_username.value, _password.value) {
            viewModelScope.launch {
                amplifyService.fetchEmailAndLog() // Optionally update email state here
                _authState.value = AuthState.Success
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
}

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object Success : AuthState()
    data class Error(val message: String) : AuthState()
}
