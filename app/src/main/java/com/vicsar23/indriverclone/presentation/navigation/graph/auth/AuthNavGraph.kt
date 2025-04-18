package com.vicsar23.indriverclone.presentation.navigation.graph.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vicsar23.indriverclone.presentation.navigation.Graph
import com.vicsar23.indriverclone.presentation.navigation.screens.auth.AuthScreen
import com.vicsar23.indriverclone.presentation.screes.auth.login.LoginScreen
import com.vicsar23.indriverclone.presentation.screes.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){ LoginScreen(navHostController) }
        composable(route = AuthScreen.Register.route){ RegisterScreen(navHostController) }
    }
}