package com.vicsar23.indriverclone.presentation.screes.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.vicsar23.indriverclone.domain.util.Resource
import com.vicsar23.indriverclone.presentation.components.ProgressBar
import com.vicsar23.indriverclone.presentation.screes.auth.register.RegisterViewModel

@Composable
fun Register(vm : RegisterViewModel = hiltViewModel()){
    val context = LocalContext.current
    when(val response = vm.registerResponse){
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if(response != null){
            Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_LONG).show()
                }
        }
    }
}