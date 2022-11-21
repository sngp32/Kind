package com.example.kind.view

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Doorbell
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF5D8555)),
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
        //TODO bottom navigation bar missing?
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB8E3AD))
                    .padding(top = 50.dp, bottom = 50.dp)
            ) {
                //empty
            }
        }
    )
    {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFFB8E3AD))
                        .padding(all = 20.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Notifications, contentDescription = null)
                            Text(text = "Notifikationer", fontSize = 28.sp)
                        }

                        Divider(color = Color.Black, thickness = 2.dp)

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "Email-notifikationer", fontSize = 20.sp, modifier = Modifier
                                    .padding(start = 5.dp)
                            )

                            Spacer(Modifier.weight(1f))

                            //OFF COLOR = 0xfffd929b
                            var selection by remember { mutableStateOf(false) }
                            Switch(
                                checked = selection,
                                onCheckedChange = { selection = !selection },
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            Text(
                                text = "Push-notifikationer", fontSize = 20.sp, modifier = Modifier
                                    .padding(start = 5.dp)
                            )

                            Spacer(Modifier.weight(1f))

                            var selection by remember { mutableStateOf(false) }
                            Switch(
                                checked = selection,
                                onCheckedChange = { selection = !selection })
                        }

                    }

                }

                Box() {
                    Text(text = "Kontoindstillinger")
                }

                Box() {
                    Text(text = "Sprog")
                }

                Box() {
                    Text(text = "Om")
                }

            }
        }
    }

}