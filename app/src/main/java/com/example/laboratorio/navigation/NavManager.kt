package com.example.laboratorio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio.view.login.RegisterView
import com.example.laboratorio.view.login.TabsView
import com.example.laboratorio.view.notas.HomeView
import com.example.laboratorio.viewmodel.LoginViewModel

@Composable
fun NavManager(loginViewModel: LoginViewModel) {
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "login") {
        composable("login") {
            TabsView(navController = navController, loginViewModel = loginViewModel)
        }
        composable("home") {
            HomeView(navController = navController)
        }
    }
}