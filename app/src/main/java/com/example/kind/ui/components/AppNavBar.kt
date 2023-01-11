package com.example.kind.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.kind.ui.components.navigation.Home
import com.example.kind.ui.components.navigation.KindDestination
import com.example.kind.ui.components.navigation.kindBottomBarScreens
import com.example.kind.ui.theme.KindTheme
import com.example.kind.ui.utils.ThemePreviews

/**
 * The app bottom navigation bar which is only visible when logged in
 *
 * @param allScreens the screen icons to be displayed in the
 * [NavigationBar] as a [NavigationBarItem].
 * @param onTabSelected called when a specific [KindDestination] is selected.
 */
@Composable
fun AppNavBar(
    allScreens: List<KindDestination>,
    onTabSelected: (KindDestination) -> Unit,
    currentScreen: KindDestination,
    isSignedIn: Boolean,
) {
    if (!isSignedIn) return

    NavigationBar {
        allScreens.forEach { screen ->
            NavigationBarItem(
                selected = currentScreen == screen,
                onClick = { onTabSelected(screen) },
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.label) }
            )
        }
    }
}

@ThemePreviews
@Composable
private fun PreviewAppNavBarLight() {
    KindTheme {
        AppNavBar(
            allScreens = kindBottomBarScreens,
            onTabSelected = { },
            currentScreen = Home,
            isSignedIn = true
        )
    }
}