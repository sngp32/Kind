package com.example.kind.view


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.ui.theme.Shapes

@Composable
fun MypageScreen(/*navController: NavController*/) {
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB8E3AD)),
            ) {
                Text(
                    text = "Min side",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 30.dp, bottom = 30.dp)
                )
            }
        },
        //TODO bottom navigation bar missing?
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB8E3AD))
                    .padding(top = 50.dp, bottom = 50.dp)
            ) {
                //empty
            }
        }
    ) {
        //this box has to exist for some reason
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
            ) {
                Spacer(modifier = Modifier.size(60.dp))
                Surface(
                    shape = Shapes.medium,
                    elevation = 2.dp,
                    modifier = Modifier.clickable { /* TODO navcontroller here?*/ }) {
                    Text(
                        text = "Min Portefølje",
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(all = 20.dp)
                    )
                }
                Spacer(modifier = Modifier.size(60.dp))
                Surface(
                    shape = Shapes.medium,
                    elevation = 2.dp,
                    modifier = Modifier.clickable { /* TODO navcontroller here?*/ }) {
                    Text(
                        text = "Indstillinger",
                        fontSize = 32.sp,
                        modifier = Modifier
                            .padding(all = 20.dp)
                    )
                }
            }
        }
    }
}