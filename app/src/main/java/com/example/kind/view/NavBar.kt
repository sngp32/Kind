package com.example.kind.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController


//TODO look at https://developer.android.com/jetpack/compose/navigation
// and https://medium.com/google-developer-experts/modular-navigation-with-jetpack-compose-fda9f6b2bef7
@Composable
fun NavBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    //TODO after navigation rework this will would not be cringe
    val items = listOf("home", "set_up_portfolio", "mypage")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Person)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                //TODO BUG, everytime it navigates to a new page it resets the highlighted button to the first one
                // the index is correctly changed and so is the selectedItem.
                selected = selectedItem == index,
                onClick = {
                    navController.navigate(item) {
                        // this at least ensures that after you are on the page if you click the button
                        // again it is highlighted
                        launchSingleTop = true
                    }
                    selectedItem = index
                }
            )
        }
    }
}