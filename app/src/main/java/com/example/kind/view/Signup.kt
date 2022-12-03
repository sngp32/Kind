package com.example.kind.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kind.ui.theme.kindGreen

@Composable
fun SignupScreen(navController: NavController) {
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

                inputField(inputText = textName, fieldText = "Name")
                Spacer(modifier = Modifier.height(10.dp))
                inputField(inputText = textEmail, fieldText = "E-mail")
                Spacer(modifier = Modifier.height(10.dp))
                inputField(inputText = textPassword, fieldText = "Password")

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(
                            0xFF454545
                        )
                    ),
                    modifier = Modifier.width(300.dp)
                ) {
                    Text(text = "SIGNUP", color = Color.White)
                }
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
            Text(text = "Already have an account?")
            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF454545)),
                modifier = Modifier.width(300.dp)
            ) {
                Text(text = "LOGIN", color = Color.White)
            }
        }

    }
}

@Composable
fun inputField(inputText: MutableState<String>, fieldText: String) {
    OutlinedTextField(
        value = inputText.value,
        onValueChange = { input -> inputText.value = input },
        label = { Text(text = fieldText) },
        modifier = Modifier.width(300.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}