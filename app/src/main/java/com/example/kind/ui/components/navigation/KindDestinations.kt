package com.example.kind.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
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

/**
 * Screens to be displayed in the bottom navigation bar
 */
val kindBottomBarScreens = listOf(Home, SetPortfolio, MyPage)