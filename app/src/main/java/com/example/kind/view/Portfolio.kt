package com.example.kind.view

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PortfolioScreen(navController: NavController, modifier: Modifier = Modifier) {
    Button(onClick = { navController.navigate("set_up_portfolio") }) {
        Text(text = "Redigér portfølje")
    }
}
