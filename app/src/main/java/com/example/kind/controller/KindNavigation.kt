package com.example.kind.controller

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

// Inspired by the android compose samples, https://github.com/android/compose-samples/

/**
 * Destinations used in the Kind app
 */
object KindDestinations {
    const val HOME_ROUTE = "home"
    const val LOGIN_ROUTE = "login"
    const val SIGNUP_ROUTE = "signup"
    const val MYPAGE_ROUTE = "mypage"
    const val SETPORTFOLIO_ROUTE = "setportfolio"
    const val PORTFOLIO_ROUTE = "portfolio"
    const val SETTINGS_ROUTE = "settings"
}

/**
 * Models the navigation actions in the app
 */
class KindNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(KindDestinations.HOME_ROUTE) {
            // Pop up to start destination of the graph.
            // This avoids a large stack fo destination
            // on the back stack as a user selects items.
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            // Avoid copies of the same destination when
            // selecting an item again.
            launchSingleTop = true
        }
    }
    val navigateToSetPortfolio: () -> Unit = {
        navController.navigate(KindDestinations.SETPORTFOLIO_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
    val navigateToMyPage: () -> Unit = {
        navController.navigate(KindDestinations.MYPAGE_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}