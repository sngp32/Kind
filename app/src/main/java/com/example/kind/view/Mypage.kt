package com.example.kind.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MypageScreen(/*navController: NavController*/) {
    Column(
        modifier = Modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB8E3AD))
                .padding(top = 30.dp, bottom = 30.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Min side",
                fontSize = 32.sp,
            )

        }
        Box() {
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = "Min Portefølje")
            }

        }
        Box() {
            Text(text = "Indstillinger")
        }
    }
}