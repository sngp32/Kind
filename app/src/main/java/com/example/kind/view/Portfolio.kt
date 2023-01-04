package com.example.kind.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color(0xffF8F8F8))
                    .padding(start = 30.dp, end = 30.dp, top = 30.dp)
            ) {
                Header()

                Spacer(modifier.height(15.dp))

                Box(modifier = Modifier
                    .height(170.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(color = Color(0xffEDEDED))) {
                    LazyColumn(modifier.padding(horizontal = 20.dp, vertical = 15.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)) {

                        //Hardcoded
                        item {
                            RowElement(modifier, title = "Sundhed", percentage = "60%")
                        }

                        item {
                            RowElement(modifier, title = "Socialt udsatte", percentage = "20%")
                        }

                        item {
                            RowElement(modifier, title = "Miljø", percentage = "20%")
                        }
                    }
                }

                Spacer(modifier.height(15.dp))

                PieChart()

                Spacer(modifier.height(15.dp))

                Box (modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
                    Button(
                        modifier = Modifier.width(180.dp).height(50.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 3.dp,
                            pressedElevation = 5.dp,
                            disabledElevation = 0.dp
                        ),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xffC7FFC6),
                            contentColor = Color.Black
                        ),
                        onClick = { navController.navigate("set_up_portfolio") }
                    ) {
                        Text(text = "Redigér portfølje")
                    }
                }
            }
        }
    }
}

@Composable
private fun RowElement(modifier: Modifier, title: String, percentage: String) {
    Box(
        modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color(0xffDFDBDB))
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, fontSize = 16.sp)
            Text(text = percentage, fontSize = 16.sp, color = Color(0xff2FA33B))
        }
    }
}


@Composable
private fun Header() {
    Text(text = "Portfølje", fontSize = 22.sp)
    Spacer(Modifier.height(10.dp))
    Text(
        text = "2 temaer",
        fontSize = 14.sp,
        color = Color(0xff858585)
    )
    Text(
        text = "6 velgørenheds-organisationer",
        fontSize = 14.sp,
        color = Color(0xff858585)
    )

}

@Composable
private fun PieChart() {
    Box(Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier.size(200.dp).clip(CircleShape).background(Color.Red)
        )
    }

}
