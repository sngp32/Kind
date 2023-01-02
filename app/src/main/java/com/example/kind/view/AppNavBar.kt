package com.example.kind.view

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kind.controller.KindDestinations
import com.example.kind.ui.theme.KindTheme

@Composable
fun AppNavBar(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToSetPortfolio: () -> Unit,
    navigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = BottomAppBarDefaults.containerColor, //TODO MaterialTheme
        contentColor = contentColorFor(BottomAppBarDefaults.containerColor) //TODO MaterialTheme
    ) {
        NavigationBarItem(
            selected = currentRoute == KindDestinations.HOME_ROUTE,
            onClick = navigateToHome,
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = null //TODO create string resources for titles
                )
            },
            label = { Text("Text") } //TODO create string resources for labels
        )
        NavigationBarItem(
            selected = currentRoute == KindDestinations.SETPORTFOLIO_ROUTE,
            onClick = navigateToSetPortfolio,
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null //TODO create string resources for titles
                )
            },
            label = { Text("Text") } //TODO create string resources for labels
        )
        NavigationBarItem(
            selected = currentRoute == KindDestinations.MYPAGE_ROUTE,
            onClick = navigateToMyPage,
            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = null //TODO create string resources for titles
                )
            },
            label = { Text("Text") } //TODO create string resources for labels
        )
    }
}

@Preview("Bar contents")
@Preview("Bar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavBar() {
    KindTheme {
        AppNavBar(
            currentRoute = KindDestinations.HOME_ROUTE,
            navigateToHome = { },
            navigateToSetPortfolio = { },
            navigateToMyPage = { }
        )
    }
}