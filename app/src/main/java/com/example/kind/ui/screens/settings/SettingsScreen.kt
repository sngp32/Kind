package com.example.kind.ui.screens.settings

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kind.ui.theme.KindTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Column() {
        //TODO perhaps move to component package for general usage
        // or place in higher caller
        SettingsTopAppBar(onBackClick)

        Column() {
            SectionTextTitle(text = "Notifications")
            SwitchButton(headlineText = "Email notifications", onSwitchButtonClick = { /* TODO */ })
            SwitchButton(headlineText = "Push notifications", onSwitchButtonClick = { /* TODO */ })

            SectionTextTitle(text = "Account Settings")
            ClickableListItem(headlineText = "Name", onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = "Email", onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = "Password", onListItemClick = { /* TODO */ })

            SectionTextTitle(text = "Language")
            RadioButton(headlineText = "English", onRadioButtonClick = { /* TODO */ })
            RadioButton(headlineText = "Danish", onRadioButtonClick = { /* TODO */ })
        }
    }
}

/**
 * Stateless clickable list item with leading radio button
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RadioButton(headlineText: String, onRadioButtonClick: () -> Unit) {
    Box(modifier = Modifier.selectable(
        selected = false,
        onClick = { onRadioButtonClick() }
    )) {
        ListItem(headlineText = { Text(text = headlineText) }, leadingContent = {
            RadioButton(
                selected = true,
                onClick = { onRadioButtonClick() })
        })
    }
}

/**
 * Stateless section text title
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SectionTextTitle(text: String) {
    //TODO perhaps this should not be a list item
    ListItem(
        headlineText = { Text(text = "") },
        supportingText = { Text(text = text) }
    )
}

/**
 * Stateless clickable list item
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun ClickableListItem(headlineText: String, onListItemClick: () -> Unit) {
    Box(modifier = Modifier.selectable(
        selected = false,
        onClick = { onListItemClick() }
    )) {
        ListItem(headlineText = { Text(text = headlineText) })
    }
}

/**
 * Stateless clickable list item with trailing switch
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SwitchButton(headlineText: String, onSwitchButtonClick: () -> Unit) {
    var isSwitched = false
    Box(modifier = Modifier.selectable(
        selected = false,
        onClick = { onSwitchButtonClick() }
    )) {
        ListItem(
            headlineText = { Text(text = headlineText) },
            trailingContent = {
                Switch(
                    checked = false,
                    onCheckedChange = { onSwitchButtonClick() })
            }
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SettingsTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        //TODO Move title out of function so it becomes stateless
        title = { Text(text = "Settings") },
        navigationIcon = {
            IconButton(onClick = { onBackClick() }) {
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
