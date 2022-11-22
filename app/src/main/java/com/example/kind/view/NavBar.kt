package com.example.kind.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController


@Composable
fun NavBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    BottomNavigation(backgroundColor = Color.LightGray) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = { Text("Home") },
            selected = selectedItem == 0,
            onClick = {
                selectedItem = 0
                navController.navigate("home") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            label = { Text("Donate") },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                /*navController.navigate("donate")*/ }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = null) },
            label = { Text("My page") },
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                navController.navigate("mypage")
            }
        )
    }
}