package com.example.kind.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

interface KindDestination {
    val icon: ImageVector
    val route: String
    val label: String
}


/**
 * Kind app navigation destinations
 */
object Home : KindDestination {
    override val icon = Icons.Rounded.Home
    override val route = "home"
    override val label = "Home"
}

object Login : KindDestination {
    override val icon = Icons.Rounded.Login
    override val route = "login"
    override val label = "Login"
}

object Signup : KindDestination {
    override val icon = Icons.Rounded.NoAccounts
    override val route = "signup"
    override val label = "Sign Up"
}

object SetPortfolio : KindDestination {
    override val icon = Icons.Rounded.Favorite
    override val route = "set_portFolio"
    override val label = "Set Portfolio"
}

object MyPage : KindDestination {
    override val icon = Icons.Rounded.Person
    override val route = "my_page"
    override val label = "My Page"
}

object MyPortfolio : KindDestination {
    override val icon = Icons.Rounded.Person
    override val route = "my_portfolio"
    override val label = "My Portfolio"
}

object Settings : KindDestination {
    override val icon = Icons.Rounded.Settings
    override val route = "settings"
    override val label = "Settings"
}

object Logout : KindDestination {
    override val icon = Icons.Rounded.PersonOff
    override val route = "login"
    override val label = "Logout"
}

object ReadMore : KindDestination {
    override val icon = Icons.Rounded.Settings
    override val route = "readMore"
    override val label = "Read More"
}

/**
 * Screens to be displayed in the bottom navigation bar
 */
val kindBottomBarScreens = listOf(Home, SetPortfolio, MyPage)