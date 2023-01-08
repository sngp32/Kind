package com.example.kind.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        },
        bottomBar = { }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = Color(0xffebebeb))
                    .padding(start = 25.dp, end = 25.dp, top = 40.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                //Hardcoded, since we do not have data for these charities yet
                item {
                    ListElement(
                        modifier,
                        title = "Din støtte",
                        text = "Hver måned støtter du 2 temaer og 6 velgørenhedsorganisationer"
                    )
                }
                item {
                    ListElement(
                        modifier,
                        title = "CHARITY UPDATE",
                        text = "Mødrehjælpen har i december måned..."
                    )
                }
                item {
                    ListElement(
                        modifier,
                        title = "CHARITY UPDATE",
                        text = "Knæk cancer fonden har i November måned..."
                    )
                }
            }
        }
    }
}


@Composable
private fun ListElement(modifier: Modifier, title: String, text: String) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clickable { },
        shape = RoundedCornerShape(30.dp)
    ) {

        Column(
            modifier = modifier.padding(30.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff37A434)
                )

            }

            Text(text = text, fontSize = 16.sp)

        }
    }
}

@Composable
private fun HomeTopAppBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Text(
            text = "Dit abonnement er på plads og du er on track til at donere 100 kr.",
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Du er blandt top 1% af donorer denne måned. Godt gået!",
            fontSize = 22.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}




