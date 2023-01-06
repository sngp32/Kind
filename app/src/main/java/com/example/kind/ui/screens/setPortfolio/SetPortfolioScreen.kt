package com.example.kind.ui.screens.setPortfolio

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.data.Charity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPortfolioScreen(modifier: Modifier = Modifier, charities: List<Charity>, onAddCharityClick: (Long) -> Unit) {
    Scaffold(
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
                    .padding(start = 25.dp, end = 25.dp, top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
                    Header()
                }

                charities.forEach { charity ->
                    item {
                        CharityElement(
                            modifier,
                            title = charity.name,
                            info = charity.description,
                            icon = Icons.Filled.Accessibility,
                            onAddCharityClick = { onAddCharityClick(charity.id) }
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}


@Composable
private fun Header() {
    Text(text = "Byg din portfølje", fontSize = 24.sp)

    Spacer(modifier = Modifier.height(14.dp))

    Text(
        text = "Vælg så mange temaer som du har lyst til.",
        fontSize = 16.sp,
        color = Color(0xff858585)
    )
    Spacer(modifier = Modifier.height(10.dp))
}


@Composable
private fun CharityElement(modifier: Modifier, title: String, info: String, icon: ImageVector, onAddCharityClick: () -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp)
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
                Icon(
                    icon,
                    contentDescription = null,
                    tint = Color(0xff37A434),
                    modifier = Modifier.size(35.dp)
                )
            }

            Text(text = info, fontSize = 16.sp)

            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    text = "Tilføj tema",
                    onClick = onAddCharityClick ,
                    backgroundColor = Color(0xffC7FFC6),
                    contentColor = Color.Black
                )
                Spacer(modifier = modifier.weight(1f))
                Button(
                    text = "Læs mere",
                    onClick = {},
                    backgroundColor = Color(0xffffffff),
                    contentColor = Color(0xff37A434)
                )

            }
        }
    }
}

@Composable
private fun Button(text: String, onClick: () -> Unit, backgroundColor: Color, contentColor: Color) {
    Button(
        onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 3.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        )
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}