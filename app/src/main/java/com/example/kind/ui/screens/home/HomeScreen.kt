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
import com.example.kind.data.KindUserData
import com.example.kind.data.News
import com.example.kind.ui.theme.KindTheme
import com.example.kind.ui.utils.BackgroundThemeCombinedPreviews
import com.example.kind.ui.utils.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    news: List<News>,
    userData: KindUserData,
    userTotalSub: Long
) {
    Scaffold(
        topBar = { HomeTopAppBar(username = userData.name, userTotalSub) }
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
            modifier = modifier.padding(30.dp), verticalArrangement = Arrangement.SpaceBetween
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
private fun HomeTopAppBar(username: String, totalSub: Long) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = "Hey $username\nYour subscription of $totalSub DKK is active",
            fontSize = 32.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "You are among 1% of donors this month. Great job!",
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@ThemePreviews
@Composable
private fun PreviewListElement() {
    KindTheme {
        ListElement(
            modifier = Modifier,
            title = "Lorem ipsum dolor sit amet consectetur adipisicing elit.",
            text = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia," +
                    "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum" +
                    "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium" +
                    "optio, eaque rerum! Provident similique accusantium nemo autem."
        )
    }
}

@BackgroundThemeCombinedPreviews
@Composable
private fun PreviewHomeTopAppBarLight() {
    KindTheme {
        HomeTopAppBar(username = "USERNAME", 500)
    }
}