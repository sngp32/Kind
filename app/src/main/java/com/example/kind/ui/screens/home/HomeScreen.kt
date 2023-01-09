package com.example.kind.ui.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.data.KindUserData
import com.example.kind.data.News

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    news: List<News>,
    userData: KindUserData
) {
    Scaffold(
        topBar = {
            HomeTopAppBar(username = userData.name)
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
                    .padding(start = 25.dp, end = 25.dp, top = 15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                // News gets loaded in reverse order, (by highest id first which is newest)
                news.asReversed().forEach { newsItem ->
                    item {
                        ListElement(
                            modifier,
                            title = newsItem.headline,
                            text = newsItem.description
                        )
                    }
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
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Text(text = text, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun HomeTopAppBar(username: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = "Hey " + username + "\nDit abonnement på 100 kr er aktivt",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Du er blandt top 1% af donorer denne måned. Godt gået!",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}




