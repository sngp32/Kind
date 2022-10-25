package com.example.kind.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
                .background(Color(0xFFB8E3AD)),
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
                OutlinedTextField(
                    value = textName.value,
                    onValueChange = { input -> textName.value = input },
                    label = { Text(text = "Name") },
                    modifier = Modifier.width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )

                )
                Spacer(modifier = Modifier.height(10.dp))
                var textEmail = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = textEmail.value,
                    onValueChange = { input -> textEmail.value = input },
                    label = { Text(text = "Email") },
                    modifier = Modifier.width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )

                )
                Spacer(modifier = Modifier.height(10.dp))
                var textPassword = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = textPassword.value,
                    onValueChange = { input -> textPassword.value = input },
                    label = { Text(text = "Password") },
                    modifier = Modifier.width(300.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White
                    )
                )
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