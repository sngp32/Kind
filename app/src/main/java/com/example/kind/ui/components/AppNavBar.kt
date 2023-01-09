package com.example.kind.ui.components

import android.content.res.Configuration
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.kind.ui.components.navigation.Home
import com.example.kind.ui.components.navigation.KindDestination
import com.example.kind.ui.components.navigation.kindBottomBarScreens
import com.example.kind.ui.theme.KindTheme

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

@Preview
@Composable
fun PreviewAppNavBarLight() {
    KindTheme {
        AppNavBar(
            allScreens = kindBottomBarScreens,
            onTabSelected = { },
            currentScreen = Home,
            isSignedIn = true
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavBarDark() {
    KindTheme {
        AppNavBar(
            allScreens = kindBottomBarScreens,
            onTabSelected = { },
            currentScreen = Home,
            isSignedIn = true
        )
    }
}