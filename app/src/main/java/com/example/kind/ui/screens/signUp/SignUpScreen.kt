package com.example.kind.ui.screens.signUp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Column(
            modifier = Modifier
                .height(600.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "SIGN UP",
                fontSize = 48.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = 20.dp, top = 50.dp)
            )
            Text(
                text = "Start your journey of giving",
                fontSize = 28.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
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
                Spacer(modifier = Modifier.height(10.dp))
                PrimaryButton(
                    navigation = {
                        onSignUpClick(
                            listOf(
                                textName.value,
                                textEmail.value,
                                textPassword.value
                            )
                        )
                    },
                    text = "SIGNUP", colors = ButtonDefaults.buttonColors()
                )
                Spacer(Modifier.weight(1f))
                OutlinedButton(
                    onClick = onLoginClick,
                    modifier = Modifier.width(300.dp)
                ) {
                    Text("LOGIN")
                }
                Spacer(modifier = Modifier.height(10.dp))
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
    )
}

@Composable
private fun PrimaryButton(navigation: () -> Unit, text: String, colors: ButtonColors) {
    Button(
        onClick = navigation,
        colors = colors,
        modifier = Modifier.width(300.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}