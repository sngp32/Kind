package com.example.kind.ui.screens.settings

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.kind.data.KindUserData
import com.example.kind.ui.theme.KindTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    userData: KindUserData
) {
    Column {
        //TODO perhaps move to component package for general usage
        // or place in higher caller
        SettingsTopAppBar(onBackClick)

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SectionTextTitle(text = "Notifications")
            SwitchButton(headlineText = "Email notifications", state = userData.areEmailNotificationEnabled, onSwitchButtonClick = { /* TODO */ })
            SwitchButton(headlineText = "Push notifications", state= userData.arePushNotificationEnabled, onSwitchButtonClick = { /* TODO */ })

            SectionTextTitle(text = "Account Settings")
            ClickableListItem(headlineText = "Name", supportingText = userData.name, onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = "Email", supportingText = userData.email,onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = "Password", "**********", onListItemClick = { /* TODO */ })

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
        selected = false, //TODO should be switched whenever another radio button is selected
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
private fun ClickableListItem(headlineText: String, supportingText: String, onListItemClick: () -> Unit) {
    Box(modifier = Modifier.selectable(
        selected = false,
        onClick = { onListItemClick() }
    )) {
        ListItem(headlineText = {
            Text(text = headlineText)}, supportingText = {Text(text = supportingText)})
    }
}

/**
 * Stateless clickable list item with trailing switch
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SwitchButton(headlineText: String, state: Boolean, onSwitchButtonClick: () -> Unit) {
    var isSwitched = false
    Box(modifier = Modifier.selectable(
        selected = false,
        onClick = { onSwitchButtonClick() }
    )) {
        ListItem(
            headlineText = { Text(text = headlineText) },
            trailingContent = {
                Switch(
                    checked = state,
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
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(),
    )
}


/*

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopAppBarPreviewDark() {
    KindTheme {
        SettingsTopAppBar(onBackClick = { })
    }
}

@Preview
@Composable
private fun TopAppBarPreviewLight() {
    KindTheme {
        SettingsTopAppBar(onBackClick = { })
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SectionTextTitlePreviewDark() {
    KindTheme {
        SectionTextTitle(text = "Section Text Title Preview")
    }
}

@Preview
@Composable
private fun SectionTextTitlePreviewLight() {
    KindTheme {
        SectionTextTitle(text = "Section Text Title Preview")
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SwitchButtonPreviewDark() {
    KindTheme {
        SwitchButton(headlineText = "Switch Button Preview") { }
    }
}

@Preview
@Composable
private fun SwitchButtonPreviewLight() {
    KindTheme {
        SwitchButton(headlineText = "Switch Button Preview") { }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ClickableListItemPreviewDark() {
    KindTheme {
        ClickableListItem(headlineText = "Clickable List Item Preview") { }
    }
}

@Preview
@Composable
private fun ClickableListItemPreviewLight() {
    KindTheme {
        ClickableListItem(headlineText = "Clickable List Item Preview") { }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RadioButtonPreviewDark() {
    KindTheme {
        RadioButton(headlineText = "Radio Button Preview") { }
    }
}

@Preview
@Composable
private fun RadioButtonPreviewLight() {
    KindTheme {
        RadioButton(headlineText = "Radio Button Preview") { }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PageSettingsPreviewDark() {
    KindTheme {
        Column {
            SettingsTopAppBar(onBackClick = { })

            SectionTextTitle(text = "Section Text Title Preview")
            SwitchButton(headlineText = "Switch Button Preview", onSwitchButtonClick = { })
            ClickableListItem(headlineText = "Clickable List Item Preview", onListItemClick = { })
            RadioButton(headlineText = "Radio Button Preview", onRadioButtonClick = { })

            SectionTextTitle(text = "Section Text Title Preview")
            SwitchButton(headlineText = "Switch Button Preview", onSwitchButtonClick = { })
            ClickableListItem(headlineText = "Clickable List Item Preview", onListItemClick = { })
            RadioButton(headlineText = "Radio Button Preview", onRadioButtonClick = { })

        }
    }
}

@Preview
@Composable
private fun PageSettingsPreviewLight() {
    KindTheme {
        Column {
            SettingsTopAppBar(onBackClick = { })

            SectionTextTitle(text = "Section Text Title Preview")
            SwitchButton(headlineText = "Switch Button Preview", onSwitchButtonClick = { })
            ClickableListItem(headlineText = "Clickable List Item Preview", onListItemClick = { })
            RadioButton(headlineText = "Radio Button Preview", onRadioButtonClick = { })

            SectionTextTitle(text = "Section Text Title Preview")
            SwitchButton(headlineText = "Switch Button Preview", onSwitchButtonClick = { })
            ClickableListItem(headlineText = "Clickable List Item Preview", onListItemClick = { })
            RadioButton(headlineText = "Radio Button Preview", onRadioButtonClick = { })
        }
    }
}

 */