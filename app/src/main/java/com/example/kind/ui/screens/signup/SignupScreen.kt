package com.example.kind.ui.screens.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.ui.theme.kindGreen

@Composable
fun SignupScreen(
    onSignUpClick: (List<String>) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .height(600.dp)
                .fillMaxWidth()
                .background(kindGreen),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "SIGNUP",
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
                var textName = remember { mutableStateOf("") }
                var textEmail = remember { mutableStateOf("") }
                var textPassword = remember { mutableStateOf("") }

                InputField(inputText = textName, fieldText = "Name")
                Spacer(modifier = Modifier.height(10.dp))
                InputField(inputText = textEmail, fieldText = "E-mail")
                Spacer(modifier = Modifier.height(10.dp))
                InputField(inputText = textPassword, fieldText = "Password")

                Button(navigation = {
                    onSignUpClick(
                        listOf(
                            textName.value,
                            textEmail.value,
                            textPassword.value
                        )
                    )
                }, text = "SIGNUP")
                Button(navigation = onLoginClick, text = "LOGIN")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(inputText: MutableState<String>, fieldText: String) {
    OutlinedTextField(
        value = inputText.value,
        onValueChange = { input -> inputText.value = input },
        label = { Text(text = fieldText) },
        modifier = Modifier.width(300.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        )
    )
}

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