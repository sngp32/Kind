package com.example.kind.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kind.view.*

@Composable
fun KindNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    /*NavHost(
        navController = navController,
        modifier = modifier
    ) {

        composable("login") { LoginScreen(navController = navController) }
        composable("signup") { SignupScreen(navController = navController) }
        //composable("home") { HomeScreen(navController = navController) }
        composable("mypage") { MypageScreen(navController = navController) }
        composable("set_up_portfolio") { SetUpPortfolioScreen(navController = navController) }
        composable("portfolio") { PortfolioScreen(navController = navController) }
        composable("settings") { SettingsScreen(navController = navController) }
    }
    */
}