package com.vicsar23.indriverclone.presentation.screes.auth.login

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.vicsar23.indriverclone.presentation.screes.auth.login.components.LoginContent

@Composable
fun LoginScreen(navHostController: NavHostController) {
    Scaffold(contentWindowInsets = WindowInsets.navigationBars) { paddingValues ->
        LoginContent(navHostController = navHostController, paddingValues = paddingValues )
    }
}