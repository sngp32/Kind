package com.example.kind.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind.ui.LoginActivity
import com.example.kind.ui.theme.kindGreen

val loginTest = LoginActivity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
                .background(kindGreen),
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
                var textEmail = remember { mutableStateOf("") }
                InputField(text = textEmail, string = "E-mail")
                Spacer(modifier = Modifier.height(10.dp))
                var textPassword = remember { mutableStateOf("") }
                InputField(text = textPassword, string = "Password")

                Button({}, "LOGIN")
                ClickableText(
                    text = AnnotatedString("Forgot your password?"),
                    onClick = {}
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(text = "Don't have an account?")
            Button({ loginTest}, "SIGN UP")
        }
    }
}

/**
 * Stateless text field for input with [text] as the input and [string] to be displayed
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(text: MutableState<String>, string: String) {
    OutlinedTextField(
        value = text.value,
        onValueChange = { input -> text.value = input },
        label = { Text(text = string) },
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