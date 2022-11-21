package com.example.kind.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.text.Typography.bullet

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // Title column
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB8E3AD))
                    .height(350.dp),
                verticalArrangement = Arrangement.Top

            ) {
                Text(
                    text = "Dit abonnement er på plads og du er on track til at donere 100 kr.",
                    fontSize = 32.sp,
                    modifier = Modifier.padding(start = 20.dp, top = 50.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Du er blandt top 1% af donorer denne måned. Godt gået!",
                    fontSize = 22.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            // Content column
            Column(modifier = Modifier
                .padding(top = 300.dp)
                .align(Alignment.Center)) {
                Column(
                    modifier = Modifier
                        .width(280.dp)
                        .height(220.dp)
                        .background(Color.White)
                        .border(
                            BorderStroke(1.dp, Color.Black)
                        )
                        .align(
                            Alignment.CenterHorizontally
                        )
                ) {
                    Text(
                        text = "Hver måned støtter du 2 temaer og 6 velgørenhedsorganisationer",
                        fontSize = 22.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .padding(top = 5.dp)
                    )
                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Green,
                                )
                            ) {
                                append("Din portefølje ->")
                            }
                        },
                        onClick = {},
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .padding(top = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .width(280.dp)
                        .height(150.dp)
                        .background(Color.White)
                        .border(
                            BorderStroke(1.dp, Color.Black)
                        )
                        .align(
                            Alignment.CenterHorizontally
                        )
                ) {
                    Text(
                        text = "CHARITY UPDATE",
                        fontSize = 22.sp,
                        color = Color(0xFFB8E3AD),
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .padding(top = 2.dp)
                    )
                    val messages = listOf(
                        "Mødrehjælpen har i december måned...",
                        "Knæk cancer fonden har i November måned..."
                    )
                    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 15.sp))
                    Text(
                        buildAnnotatedString {
                            messages.forEach {
                                withStyle(style = paragraphStyle) {
                                    append(bullet)
                                    append("\t\t")
                                    append(it)
                                }
                            }
                        },
                        Modifier
                            .padding(start = 20.dp)
                            .padding(top = 2.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.LightGray)
                .align(Alignment.BottomCenter),horizontalArrangement = Arrangement.Center
        ) {
            val MyAppIcons = Icons.Rounded
            Icon(
                Icons.Filled.Home,
                "home",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(80.dp))
            Icon(
                Icons.Filled.Favorite,
                "buildPortfolio",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(80.dp))
            Icon(
                Icons.Filled.Person,
                "myPage",
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterVertically)
            )

        }
    }
}