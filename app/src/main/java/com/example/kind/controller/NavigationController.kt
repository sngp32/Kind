package com.example.kind.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kind.view.HomeScreen
import com.example.kind.view.LoginScreen
import com.example.kind.view.SignupScreen


@Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "login") {
            composable("login") { LoginScreen(navController = navController) }
            composable("signup") { SignupScreen(navController = navController) }
            composable("home"){ HomeScreen(navController = navController)}
        }
    }
