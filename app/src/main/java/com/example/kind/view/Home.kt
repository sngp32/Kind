package com.example.kind.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .height(500.dp)
            .fillMaxWidth()
            .background(Color(0xFFB8E3AD)),
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Dit abonnement er på plads og du er on track til at donere 100 kr.",
            fontSize = 38.sp,
            modifier = Modifier.padding(start = 20.dp, top = 50.dp)
        )
        Text(
            text = "Du er blandt top 1% af donorer denne måned. Godt gået!",
            fontSize = 28.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(90.dp))
    }
}