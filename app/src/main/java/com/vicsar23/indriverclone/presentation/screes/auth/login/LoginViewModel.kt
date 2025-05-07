package com.vicsar23.indriverclone.presentation.screes.auth.login
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vicsar23.indriverclone.domain.useCases.auth.AuthUseCase
import com.vicsar23.indriverclone.presentation.screes.auth.login.components.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf(value = "")
        private set

    fun onEmailInput(email:String){
        state  = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state  = state.copy(password = password)
    }

    fun  loginSubmit() = viewModelScope.launch{
        if(isValidForm() ){
            val result = authUseCase.login(email = state.email, password = state.password)

        }

    }

    private fun isValidForm() : Boolean {
        errorMessage = ""

        if(state.email.isEmpty()){
            errorMessage = "Ingresa el email"
            return false
        }

        else if(state.password.isEmpty()){
            errorMessage = "Ingresa la contraseña"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "Ingresa un correo válido"
            return false
        }
        else if(state.password.length <6 ){
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }

        return true
    }
}