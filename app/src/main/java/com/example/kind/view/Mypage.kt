package com.example.kind.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MypageScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB8E3AD)),
            ) {
                Text(
                    text = "Min side",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 30.dp, bottom = 30.dp)
                )
            }
        },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.LightGray) { NavBar(navController) }
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(60.dp))
            PageButton(str = "Min Portefølje", icon = Icons.Filled.Person)
            Spacer(modifier = Modifier.height(60.dp))
            PageButton(str = "Indstillinger", icon = Icons.Filled.Settings)
        }
    }
}

@Composable
fun PageButton(str: String, icon: ImageVector /*TODO missing onclick parameter?*/) {
    Button(
        onClick = {/*TODO*/},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Text(
                text = str,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(all = 10.dp)
            )
        }
    }
}