package com.example.kind.ui.screens.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.R
import com.example.kind.ui.theme.KindTheme
import com.example.kind.ui.utils.BackgroundThemeCombinedPreviews

@Composable
fun SignUpScreen(
    onSignUpClick: (List<String>) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        SignUpHeader()

        Spacer(modifier = Modifier.height(90.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var inputName = remember { mutableStateOf("") }
            var inputEmail = remember { mutableStateOf("") }
            var inputPassword = remember { mutableStateOf("") }

            SignUpInputFields(
                inputName = inputName.value,
                inputEmail = inputEmail.value,
                inputPassword = inputPassword.value,
                { input -> inputName.value = input },
                { input -> inputEmail.value = input },
                { input -> inputPassword.value = input }
            )

            Spacer(Modifier.height(5.dp))

            SignUpButton(
                onSignUpClick = onSignUpClick,
                inputName = inputName.value,
                inputEmail = inputEmail.value,
                inputPassword = inputPassword.value,
                modifier = Modifier.fillMaxWidth()
            )

        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(R.string.haveaccount_field),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            LoginButton(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun SignUpHeader() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(start = 20.dp, top = 50.dp)
    ) {
        Text(
            text = stringResource(R.string.signup_title),
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = stringResource(R.string.greeting),
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Composable
private fun SignUpInputFields(
    inputName: String,
    inputEmail: String,
    inputPassword: String,
    onNameInput: (String) -> Unit,
    onEmailInput: (String) -> Unit,
    onPasswordInput: (String) -> Unit
) {
    InputField(
        value = inputName,
        label = stringResource(R.string.name_field),
        onValueChange = onNameInput
    )

    Spacer(modifier = Modifier.height(10.dp))

    InputField(
        value = inputEmail,
        label = stringResource(R.string.email_field),
        onValueChange = onEmailInput
    )

    Spacer(modifier = Modifier.height(10.dp))

    InputField(
        value = inputPassword,
        label = stringResource(R.string.password_field),
        onValueChange = onPasswordInput
    )
}

/**
 * Stateless text field for input with [value] as the input and [label] to be displayed
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun SignUpButton(
    onSignUpClick: (List<String>) -> Unit,
    inputName: String,
    inputEmail: String,
    inputPassword: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onSignUpClick(
                listOf(
                    inputName,
                    inputEmail,
                    inputPassword
                )
            )
        },
        modifier = modifier
    ) {
        Icon(Icons.Filled.PersonAdd, contentDescription = stringResource(R.string.signup_button))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.signup_button))
    }
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Filled.Login, contentDescription = stringResource(R.string.login_button))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.login_button))
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewLoginScreen() {
    KindTheme {
        SignUpScreen(
            onLoginClick = { },
            onSignUpClick = { },
        )
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewSignUpHeader() {
    KindTheme {
        SignUpHeader()
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewInputField() {
    KindTheme {
        InputField(value = "", label = "Preview Input Field", onValueChange = { })
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewSignUpButton() {
    KindTheme {
        SignUpButton(onSignUpClick = { }, inputName = "", inputEmail = "", inputPassword = "")
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewLoginButton() {
    KindTheme {
        LoginButton(onClick = { })
    }
}