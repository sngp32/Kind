package com.example.kind

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kind.ui.components.navigation.*
import com.example.kind.ui.theme.KindTheme
import com.example.kind.view.AppNavBar
import com.example.kind.ui.screens.home.HomeScreen
import com.example.kind.ui.screens.portfolio.PortfolioScreen
import com.example.kind.view.SettingsScreen
import com.example.kind.ui.screens.myPage.MyPageScreen
import com.example.kind.ui.screens.setPortfolio.SetPortfolioScreen
import com.example.kind.view.LoginScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KindApp() {
    KindTheme {
        val navController = rememberNavController()

        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination

        val currentScreen =
            kindBottomBarScreens.find { it.route == currentDestination?.route } ?: Home

        Scaffold(
            topBar = {},
            bottomBar = {
                AppNavBar(
                    allScreens = kindBottomBarScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            KindNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun KindNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Login.route,
        modifier = modifier
    ) {
        composable(route = Login.route) {
            LoginScreen()
        }
        composable(route = Home.route) {
            HomeScreen()
        }
        composable(route = SetPortfolio.route) {
            SetPortfolioScreen()
        }
        composable(route = MyPage.route) {
            MyPageScreen(onPortfolioClick = {navController.navigateSingleTopTo(MyPortfolio.route)},
            onSettingsClick = {navController.navigateSingleTopTo(Settings.route)})
        }
        composable(route = Settings.route) {
            SettingsScreen()
        }
        composable(route = MyPortfolio.route) {
            PortfolioScreen(onSetPortfolioClick = {navController.navigateSingleTopTo(SetPortfolio.route)})
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }