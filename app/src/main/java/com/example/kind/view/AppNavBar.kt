package com.example.kind.view

import android.content.res.Configuration
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.kind.navigation.Home
import com.example.kind.navigation.KindBottomBarDestination
import com.example.kind.navigation.KindDestination
import com.example.kind.navigation.kindBottomBarScreens
import com.example.kind.ui.theme.KindTheme

@Composable
fun AppNavBar(
    allScreens: List<KindBottomBarDestination>,
    onTabSelected: (KindDestination) -> Unit,
    currentScreen: KindDestination
) {
    NavigationBar(
        containerColor = BottomAppBarDefaults.containerColor, //TODO MaterialTheme
        contentColor = contentColorFor(BottomAppBarDefaults.containerColor), //TODO MaterialTheme
    ) {
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

@Preview("Bar contents")
@Preview("Bar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavBar() {
    KindTheme {
        AppNavBar(allScreens = kindBottomBarScreens, onTabSelected = {}, currentScreen = Home)
    }
}