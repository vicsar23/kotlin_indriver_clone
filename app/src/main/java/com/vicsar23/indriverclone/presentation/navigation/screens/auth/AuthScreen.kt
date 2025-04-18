package com.vicsar23.indriverclone.presentation.navigation.screens.auth

sealed class AuthScreen(val route: String){
    object Login : AuthScreen("/login")
    object Register : AuthScreen("/register")
}