package com.vicsar23.indriverclone.presentation.screes.auth.register
import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf(value = "")
        private set

    fun onNameInput(name:String){
        state  = state.copy(name = name)
    }

    fun onLastNameInput(lastName:String){
        state  = state.copy(lastName = lastName)
    }

    fun onEmailInput(email:String){
        state  = state.copy(email = email)
    }

    fun onPhoneInput(phone:String){
        state  = state.copy(phone = phone)
    }

    fun onPasswordInput(password:String){
        state  = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword:String){
        state  = state.copy(confirmPassword = confirmPassword)
    }

    fun  loginSubmit(){
        if(!isValidForm() ) return;
        Log.d("RegisterViewModel", "Name: ${state.name}")
        Log.d("RegisterViewModel", "LastName: ${state.lastName}")
        Log.d("RegisterViewModel", "Email: ${state.email}")
        Log.d("RegisterViewModel", "Phone: ${state.phone}")
        Log.d("RegisterViewModel", "Password: ${state.password}")
    }

    private fun isValidForm() : Boolean {
        errorMessage = ""

        if(state.name.isEmpty()){
            errorMessage = "Ingresa el nombre"
            return false
        }

        else if(state.lastName.isEmpty()){
            errorMessage = "Ingresa el apellido"
            return false
        }

        else if(state.email.isEmpty()){
            errorMessage = "Ingresa el email"
            return false
        }

        else if(state.phone.isEmpty()){
            errorMessage = "Ingresa el teléfono"
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
        else if(!state.password.equals(state.confirmPassword)){
            errorMessage = "Las contraseñas deben coincidir"
            return false
        }

        return true
    }
}