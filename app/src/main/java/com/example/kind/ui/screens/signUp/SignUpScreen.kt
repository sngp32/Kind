package com.example.kind.ui.screens.signUp

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.ui.theme.KindTheme

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
                .fillMaxHeight()
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

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun PreviewInputFieldLight() {
    KindTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            InputField(inputText = mutableStateOf(""), fieldText = "Preview Input Field Light")
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewInputFieldDark() {
    KindTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            InputField(inputText = mutableStateOf(""), fieldText = "Preview Input Field Dark")
        }
    }
}

@Preview
@Composable
private fun PreviewButtonLight() {
    KindTheme {
        PrimaryButton(
            navigation = { /*TODO*/ },
            text = "Preview Button Light",
            colors = ButtonDefaults.buttonColors()
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun PreviewButtonDark() {
    KindTheme {
        PrimaryButton(
            navigation = { /*TODO*/ },
            text = "Preview Button Dark",
            colors = ButtonDefaults.buttonColors()
        )
    }
}