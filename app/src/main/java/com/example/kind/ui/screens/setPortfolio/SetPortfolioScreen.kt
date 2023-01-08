package com.example.kind.ui.screens.setPortfolio

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.data.Charity
import com.example.kind.ui.theme.KindTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPortfolioScreen(
    modifier: Modifier = Modifier,
    charities: List<Charity>,
    onAddCharityClick: (Long) -> Unit
) {
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
                            description = charity.description,
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
    Column {
        Text(text = "Byg din portfølje", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "Vælg så mange temaer som du har lyst til.",
            fontSize = 16.sp,
            color = Color(0xff858585)
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun CharityElement(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    icon: ImageVector,
    onAddCharityClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp),
        shape = RoundedCornerShape(30.dp)
    ) {

        Column(
            modifier = Modifier.padding(30.dp),
        ) {

            CardHeader(
                modifier = Modifier.weight(1f),
                title = title,
                icon = icon,
            )
            Spacer(modifier = Modifier.height(5.dp))
            CardDescription(description)
            Spacer(modifier = Modifier.weight(1f))
            CardButtons(modifier, onAddCharityClick)
        }
    }
}



@Composable
private fun CardHeader(
    modifier: Modifier,
    title: String,
    icon: ImageVector,
) {
    val titleSize = 18.sp
    val iconSize = with(LocalDensity.current) { titleSize.toDp()*2 }
    Row(verticalAlignment = Alignment.CenterVertically) {
        CardTitle(title = title, fontSize = titleSize, modifier = modifier)
        Spacer(modifier = Modifier.width(5.dp))

        CardIcon(icon = icon, iconSize = iconSize)
    }
}

@Composable
private fun CardTitle(title: String, fontSize: TextUnit, modifier: Modifier) {
    Text(
        text = title,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        modifier = modifier
    )
}

@Composable
private fun CardIcon(icon: ImageVector, iconSize: Dp) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.inverseSurface, //TODO not sure which one is best here
        modifier = Modifier.size(iconSize)
    )
}

@Composable
private fun CardDescription(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun CardButtons(
    modifier: Modifier,
    onAddCharityClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onAddCharityClick) {
            Text(text = "Add theme")
        }

        Spacer(modifier = modifier.weight(1f))

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Read more")
        }
    }
}

@Preview
@Composable
private fun PreviewHeaderLight() {
    KindTheme {
        Header()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHeaderDark() {
    KindTheme {
        Header()
    }
}

@Preview
@Composable
private fun PreviewCharityCardLight() {
    KindTheme {
        CharityElement(
            title = "Charity Card Preview Light. Lorem ipsum dolor sit amet consectetur adipisicing elit.",
            description = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia," +
                    "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum" +
                    "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium" +
                    "optio, eaque rerum!",
            icon = Icons.Filled.LightMode
        ) { }
    }

}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewCharityCardDark() {
    KindTheme {
        CharityElement(
            title = "Charity Card Preview Dark. Lorem ipsum dolor sit amet consectetur adipisicing elit.",
            description = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia," +
                    "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum" +
                    "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium" +
                    "optio, eaque rerum!",
            icon = Icons.Filled.DarkMode
        ) { }
    }
}

@Preview
@Composable
private fun ButtonPreviewLight() {
    Button(
        text = "ButtonPreviewLight",
        onClick = {},
        backgroundColor = Color(0xffffffff),
        contentColor = Color(0xff37A434)
    )
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ButtonPreviewDark() {
    Button(
        text = "ButtonPreviewDark",
        onClick = {},
        backgroundColor = Color(0xffffffff),
        contentColor = Color(0xff37A434)
    )
}