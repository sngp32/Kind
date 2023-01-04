package com.example.kind.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kind.ui.theme.KindTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    Column() {
        SettingsTopAppBar()

        Column() {
            Text(text = "Notifications", fontSize = 11.sp)

            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(
                    headlineText = { Text(text = "Email notifications") },
                    trailingContent = { Switch(checked = false, onCheckedChange = {/*TODO*/}) }
                )
            }

            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(
                    headlineText = { Text(text = "Push notifications") },
                    trailingContent = { Switch(checked = false, onCheckedChange = {/*TODO*/}) }
                )
            }

            Text(text = "Account Settings", fontSize = 11.sp)
            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(headlineText = { Text(text = "Name") })
            }
            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(headlineText = { Text(text = "Email") })
            }
            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(headlineText = { Text(text = "Password") })
            }


            Text(text = "Language", fontSize = 11.sp)


            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(headlineText = { Text(text = "English") }, leadingContent = {
                    RadioButton(
                        selected = true,
                        onClick = { /*TODO*/ })
                })
            }

            Box(modifier = Modifier.selectable(
                selected = false,
                onClick = { /*TODO*/ }
            )) {
                ListItem(headlineText = { Text(text = "Dansk") }, leadingContent = {
                    RadioButton(
                        selected = true,
                        onClick = { /*TODO*/ })
                })
            }

        }


    }

}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SettingsTopAppBar() {
    TopAppBar(
        title = { Text(text = "Settings") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(),
    )
}

@Preview
@Composable
fun SettingsPreview() {
    KindTheme {
        SettingsScreen()
    }
}
