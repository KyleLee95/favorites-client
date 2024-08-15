package favorites.client.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import favorites.client.data.models.contact.SamMailerResponse
import favorites.client.data.repository.ApiProvider
import favorites.client.data.repository.SamMailerRepository
import kotlinx.coroutines.launch

class SamMailerViewModel() : ViewModel() {
    private val samMailerRepository: SamMailerRepository = SamMailerRepository(ApiProvider.samMailerAPi())


    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    fun setLoading(loading: Boolean){
        _isLoading.value = loading
    }

    private val _isSuccess = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess
    fun setSuccess(success: Boolean){
        _isSuccess.value = success
    }

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> = _errorMessage
    fun setErrorMessage(message:String){
        _errorMessage.value = message

    }

    fun submitEmail(email: SamMailerResponse) {
        setSuccess(false)
        setLoading(true)
        setErrorMessage("")

        viewModelScope.launch {
            val response = samMailerRepository.submitEmail(email)
            setLoading(false)

            if (response.isSuccessful) {
                setSuccess(true)
            } else {
                setErrorMessage(
                    "Failed to send email: ${response.message()}"
                )
            }
        }
    }
}
