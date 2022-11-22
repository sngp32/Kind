package com.example.kind.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kind.view.*


@Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "login") {
            composable("login") { LoginScreen(navController = navController) }
            composable("signup") { SignupScreen(navController = navController) }
            composable("home"){ HomeScreen(navController = navController)}
            composable("mypage") { MypageScreen(navController = navController) }
            //composable("portfolio") { PortfolioScreen(navController = navController) }
            //composable("settings") { SettingsScreen(navController = navController) }
        }
    }
