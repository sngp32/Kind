package com.example.kind.ui

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
import com.example.kind.MainViewModel
import com.example.kind.ui.components.navigation.*
import com.example.kind.ui.theme.KindTheme
import com.example.kind.ui.components.AppNavBar
import com.example.kind.ui.screens.home.HomeScreen
import com.example.kind.ui.screens.login.LoginScreen
import com.example.kind.ui.screens.portfolio.PortfolioScreen
import com.example.kind.ui.screens.settings.SettingsScreen
import com.example.kind.ui.screens.myPage.MyPageScreen
import com.example.kind.ui.screens.setPortfolio.SetPortfolioScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kind.ui.screens.signup.SignupScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KindApp(viewModel: MainViewModel = viewModel()) {
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
            KindNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                viewModel = viewModel
            )
        }
    }
}

@Composable
private fun KindNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val charities by viewModel.charities

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
            SetPortfolioScreen(
                charities = charities,
                onAddCharityClick = { charityId -> viewModel.subscribeToCharity(charityId) })
        }
        composable(route = MyPage.route) {
            MyPageScreen(onPortfolioClick = { navController.navigateSingleTopTo(MyPortfolio.route) },
                onSettingsClick = { navController.navigateSingleTopTo(Settings.route) })
        }
        composable(route = Settings.route) {
            SettingsScreen(modifier = modifier, onBackClick = { navController.popBackStack() })
        }
        composable(route = MyPortfolio.route) {
            PortfolioScreen(onSetPortfolioClick = { navController.navigateSingleTopTo(SetPortfolio.route) })
        }
        composable(route = Signup.route) {
            SignupScreen(onSignUpClick = { signUpData -> viewModel.signUp(signUpData) },
            onLoginClick = { navController.navigateSingleTopTo(Login.route)})
        }
    }
}

private fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }