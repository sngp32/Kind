package com.example.kind.ui.screens.setPortfolio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.data.Charity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadMoreScreen(onBackClick: () -> Unit, charity: Charity) {
    Scaffold(
        topBar = { topBar(onBackClick) },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = charity.name,
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = charity.readMore,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Read more") },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(),
    )
}