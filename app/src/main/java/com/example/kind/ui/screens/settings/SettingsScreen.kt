package com.example.kind.ui.screens.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.kind.R
import com.example.kind.data.KindUserData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    userData: KindUserData
) {
    Column {
        //TODO perhaps move to component package for general usage
        // or place in higher caller
        SettingsTopAppBar(onBackClick)

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            SectionTextTitle(text = stringResource(R.string.notifications))
            SwitchButton(headlineText = stringResource(R.string.email_notifications), state = userData.areEmailNotificationEnabled, onSwitchButtonClick = { /* TODO */ })
            SwitchButton(headlineText = stringResource(R.string.push_notifications), state= userData.arePushNotificationEnabled, onSwitchButtonClick = { /* TODO */ })

            SectionTextTitle(text = stringResource(R.string.account_settings))
            ClickableListItem(headlineText = stringResource(R.string.name_field), supportingText = userData.name, onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = stringResource(R.string.email_field), supportingText = userData.email,onListItemClick = { /* TODO */ })
            ClickableListItem(headlineText = stringResource(R.string.password_field), "**********", onListItemClick = { /* TODO */ })

            SectionTextTitle(text = stringResource(R.string.language))
            RadioButton(headlineText = stringResource(R.string.english), onRadioButtonClick = { /* TODO */ })
            RadioButton(headlineText = stringResource(R.string.danish), onRadioButtonClick = { /* TODO */ })
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
        title = { Text(text = stringResource(R.string.settings)) },
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