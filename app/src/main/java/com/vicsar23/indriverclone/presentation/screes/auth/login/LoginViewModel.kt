package com.vicsar23.indriverclone.presentation.screes.auth.login
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.vicsar23.indriverclone.presentation.screes.auth.login.components.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEmailInput(email:String){
        state  = state.copy(email = email)
    }

    fun onPasswordInput(password:String){
        state  = state.copy(password = password)
    }

    fun  loginSubmit(){
        Log.d("LoginViewModel", "Email: ${state.email}")
        Log.d("LoginViewModel", "Password: ${state.password}")
    }
}