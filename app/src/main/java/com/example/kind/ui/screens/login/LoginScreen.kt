package com.example.kind.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun LoginScreen(
    onLoginClick: (List<String>) -> Unit,
    onSignUpClick: () -> Unit,
    onIncorrectLogin: () -> Unit,
    onResetPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        LoginHeader()

        Spacer(modifier = Modifier.height(90.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var inputEmail = remember { mutableStateOf("") }
            var inputPassword = remember { mutableStateOf("") }

            LoginInputFields(
                inputEmail.value,
                inputPassword.value,
                { input -> inputEmail.value = input },
                { input -> inputPassword.value = input }
            )

            Spacer(Modifier.height(5.dp))

            Row {
                ResetPasswordButton(onResetPasswordClick)
                Spacer(modifier = Modifier.weight(1f))
                LoginButton(onLoginClick = {
                    onLoginClick(
                        listOf(
                            inputEmail.value, inputPassword.value
                        )
                    )
                })
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = stringResource(R.string.noaccount_field),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            SignUpButton(
                onClick = onSignUpClick,
                modifier = Modifier.width(300.dp)
            )
        }
    }
}

@Composable
private fun LoginHeader() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(start = 20.dp, top = 50.dp)
    ) {
        Text(
            text = stringResource(R.string.login_title),
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
private fun LoginInputFields(
    inputEmail: String,
    inputPassword: String,
    onEmailInput: (String) -> Unit,
    onPasswordInput: (String) -> Unit
) {
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
fun ResetPasswordButton(onResetPasswordClick: () -> Unit) {
    TextButton(onClick = onResetPasswordClick) {
        Icon(Icons.Filled.LockReset, contentDescription = stringResource(R.string.resetpassword_button))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.resetpassword_button))
    }
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    OutlinedButton(onClick = onClick, modifier) {
        Icon(Icons.Filled.PersonAdd, contentDescription = stringResource(R.string.signup_button))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.signup_button))
    }
}

@Composable
private fun LoginButton(
    onLoginClick: () -> Unit,
) {
    Button(
        onClick = onLoginClick
    ) {
        Icon(Icons.Filled.Login, contentDescription = stringResource(R.string.login_button))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.login_button))
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewLoginScreen() {
    KindTheme {
        LoginScreen(
            onLoginClick = { },
            onSignUpClick = { },
            onIncorrectLogin = { },
            onResetPasswordClick = { }
        )
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewLoginHeader() {
    KindTheme {
        LoginHeader()
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
private fun PreviewResetPasswordButton() {
    KindTheme {
        ResetPasswordButton {}
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewLoginButton() {
    KindTheme {
        LoginButton(onLoginClick = { })
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewSignUpButton() {
    KindTheme {
        SignUpButton(onClick = { }, modifier = Modifier)
    }
}