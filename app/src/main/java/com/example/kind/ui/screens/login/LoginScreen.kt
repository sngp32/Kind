package com.example.kind.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.ui.components.navigation.Login
import com.example.kind.ui.components.navigation.Signup

@Composable
fun LoginScreen(
    onLoginClick: (List<String>) -> Unit,
    onSignUpClick: () -> Unit,
    onIncorrectLogin: () -> Unit,
    onResetPasswordClick: () -> Unit
) {
    var inputEmail = remember { mutableStateOf("") }
    var inputPassword = remember { mutableStateOf("") }
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
                LoginButton(onLoginClick, inputEmail.value, inputPassword.value)
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
                text = "Don't have an account?",
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
fun ResetPasswordButton(onResetPasswordClick: () -> Unit) {
    TextButton(onClick = onResetPasswordClick) {
        Text(text = "Reset password")
    }
}

@Composable
private fun SignUpButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    OutlinedButton(onClick = onClick, modifier) {
        Text(text = Signup.label)
    }
}

@Composable
private fun LoginButton(
    onLoginClick: (List<String>) -> Unit,
    inputEmail: String,
    inputPassword: String
) {
    Button(onClick = {
        onLoginClick(
            listOf(
                inputEmail,
                inputPassword
            )
        )
    }) {
        Text(text = Login.label)
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
        label = "E-mail",
        onValueChange = onEmailInput
    )
    Spacer(modifier = Modifier.height(10.dp))
    InputField(
        value = inputPassword,
        label = "Password",
        onValueChange = onPasswordInput
    )
}

@Composable
private fun LoginHeader() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(start = 20.dp, top = 50.dp)
    ) {
        Text(
            text = "LOGIN",
            fontSize = 48.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = "Start your journey of giving",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
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

/**
 * Stateless button with [text] to be displayed and [navigation] for rerouting
 */
@Composable
private fun Button(navigation: () -> Unit, text: String) {
    Button(
        onClick = navigation,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF454545)),
        modifier = Modifier.width(300.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun PreviewInputFieldLight() {
    InputField(value = "", label = "Preview Input Field", onValueChange = { })
}

@SuppressLint("UnrememberedMutableState")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewInputFieldDark() {
    InputField(value = "", label = "Preview Input Field", onValueChange = { })
}

@Preview
@Composable
private fun PreviewButtonLight() {
    Button(navigation = { }, text = "Preview Button")
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewButtonDark() {
    Button(navigation = { }, text = "Preview Button")
}