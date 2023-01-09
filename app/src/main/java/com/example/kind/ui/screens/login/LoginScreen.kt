package com.example.kind.ui.screens.login

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.ui.components.navigation.Signup

@Composable
fun LoginScreen(
    onLoginClick: (List<String>) -> Unit,
    onSignUpClick: () -> Unit,
    onIncorrectLogin: () -> Unit, 
) {
    var textEmail = remember { mutableStateOf("") }
    var textPassword = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "LOGIN",
                fontSize = 48.sp,
                modifier = Modifier.padding(start = 20.dp, top = 50.dp)
            )
            Text(
                text = "Start your journey of giving",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(90.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputField(
                    value = textEmail.value,
                    label = "E-mail",
                    onValueChange = { input -> textEmail.value = input })
                Spacer(modifier = Modifier.height(10.dp))
                InputField(
                    value = textPassword.value,
                    label = "Password",
                    onValueChange = { input -> textPassword.value = input })

                Button(navigation = {
                    onLoginClick(
                        listOf(
                            textEmail.value,
                            textPassword.value
                        )
                    )
                }, text = "LOGIN")
                ClickableText(
                    text = AnnotatedString("Forgot your password?"),
                    onClick = {  }
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Don't have an account?")
            val signUpButton = Signup
            Button(navigation = onSignUpClick, text = signUpButton.label)
        }
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
        modifier = Modifier.width(300.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        )
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