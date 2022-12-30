package com.example.kind.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind.ui.theme.kindGreen
import com.example.kind.ui.theme.kindGreenDark


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(kindGreenDark),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 5.dp, start = 5.dp, bottom = 5.dp)
                ) {
                    Icon(
                        Icons.Filled.KeyboardBackspace,
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(end = 5.dp)
                    )

                    //Spacer(Modifier.width(5.dp))

                    Text(
                        text = "Indstillinger",
                        fontSize = 36.sp,
                    )
                }
            }
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.LightGray) { NavBar(navController) }
        }
    )
    {_ -> //TODO utilize padding, suppressed up top
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(kindGreen)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .padding(all = 20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Notifications, contentDescription = null)
                            Text(text = "Notifikationer", fontSize = 28.sp)
                        }

                        Divider(color = Color.Black, thickness = 2.dp)

                        SwitchItem(text = "E-mail meddelelser")
                        SwitchItem(text = "Push meddelelser")

                    }
                }
                Box(
                    modifier = Modifier
                        .padding(all = 20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Person, contentDescription = null)
                            Text(text = "Kontoindstillinger", fontSize = 28.sp)
                        }

                        Divider(color = Color.Black, thickness = 2.dp)

                        UserSettingElement(text = "Navn", text2 = "Mikkel Pedersen")
                        UserSettingElement(text = "E-Mail", text2 = "MikkelPedersen1431@gmail.com")
                        UserSettingElement(text = "Password", text2 = "Skift Password")
                        UserSettingElement(text = "Sprog", text2 = "Dansk")
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(all = 20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Info, contentDescription = null)
                            Text(text = "Om", fontSize = 28.sp)
                        }

                        Divider(color = Color.Black, thickness = 2.dp)

                        var aboutField = remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = aboutField.value,
                            onValueChange = { input -> aboutField.value = input },
                            label = { Text(text = "Om") },
                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White
                            )
                        )
                    }
                }

            }
        }
    }
}

/*TODO get text2 from stored data, and functionality to change the information */
@Composable

fun UserSettingElement(text: String, text2:String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = text, fontSize = 20.sp, modifier = Modifier
                .padding(start = 5.dp)
        )

        Spacer(Modifier.weight(1f))

        Button(onClick = { /*TODO*/ }, modifier = Modifier.width(260.dp)) {
            Text(
                text = text2, fontSize = 12.sp
            )
        }

    }

}

@Composable
fun SwitchItem(text: String /*TODO onswitch parameter?*/) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(
            text = text, fontSize = 20.sp, modifier = Modifier
                .padding(start = 5.dp)
        )

        Spacer(Modifier.weight(1f))

        var selection by remember { mutableStateOf(false) }
        //TODO switch functionality
        Switch(
            checked = selection,
            onCheckedChange = { selection = !selection })
    }
}