package com.example.kind.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
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
                    .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                    .background(Color(0xFFB8E3AD))
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
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(80.dp))

                PageButton(
                    str = "Min Portefølje",
                    icon = Icons.Filled.Person,
                    onClick = {navController.navigate("portfolio")}
                )

            Spacer(modifier = Modifier.height(60.dp))

                PageButton(
                    str = "Indstillinger",
                    icon = Icons.Filled.Settings,
                    onClick = {navController.navigate("settings")}
                )

            Spacer(modifier = Modifier.weight(1.0f))
            Box(modifier = Modifier.fillMaxWidth().height(140.dp).clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)).background(Color(0xFFB8E3AD)))
        }



    }
}

@Composable
fun PageButton(str: String, icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.width(250.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(10.dp)
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