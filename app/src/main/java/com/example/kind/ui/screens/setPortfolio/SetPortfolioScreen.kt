package com.example.kind.ui.screens.setPortfolio

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kind.R
import com.example.kind.data.Charity
import com.example.kind.ui.theme.KindTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPortfolioScreen(
    modifier: Modifier = Modifier,
    charities: List<Charity>,
    onAddCharityClick: (Long) -> Unit,
    onReadMoreClick: (Long) -> Unit
    ) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
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
                            icon = Icons.Filled.Accessibility,
                            charity = charity,
                            onAddCharityClick = { onAddCharityClick(charity.id) },
                            onReadMoreClick = { onReadMoreClick(charity.id) }
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Column {
        Text(
            text = stringResource(R.string.setportfolio_title),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = stringResource(R.string.setportfolio_info),
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun CharityElement(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    charity: Charity,
    onAddCharityClick: () -> Unit,
    onReadMoreClick: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp)
            .shadow(3.dp, shape = RoundedCornerShape(30.dp)),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier.padding(30.dp),
        ) {

            CardHeader(
                modifier = Modifier.weight(1f),
                title = charity.name,
                icon = icon,
            )
            Spacer(modifier = Modifier.height(5.dp))
            CardDescription(charity.description)
            Spacer(modifier = Modifier.weight(1f))
            CardButtons(modifier, charity, onAddCharityClick, onReadMoreClick)
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
    val iconSize = with(LocalDensity.current) { titleSize.toDp() * 2 }
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
        tint = MaterialTheme.colorScheme.primary, //TODO not sure which one is best here
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
    charity: Charity,
    onAddCharityClick: () -> Unit,
    onReadMoreClick: () -> Unit
) {

    val showDialog = remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(onClick = {showDialog.value = true }) {
            Text(text = stringResource(R.string.add_theme))
        }

        Spacer(modifier = modifier.weight(1f))

        OutlinedButton(onClick = onReadMoreClick) {
            Text(text = stringResource(R.string.read_more))
        }
    }

    if (showDialog.value) {
        addThemeDialog(showDialog, charity, onAddCharityClick)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun addThemeDialog(
    showDialog: MutableState<Boolean>,
    charity: Charity,
    onAddCharityClick: () -> Unit
) {

    var number by remember {
        mutableStateOf(0)
    }

    val checkbox = remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },
        title = {
            Text(text = charity.name)
        },
        text = {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = number.toString(),
                    onValueChange = {
                        if (it.isNotBlank()) {
                            number = it.toIntOrNull() ?: 0
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = {
                        Text("Enter amount")
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row (){

                    Checkbox(
                        checked = checkbox.value,
                        onCheckedChange = {
                            checkbox.value = it }

                    )
                    Text( modifier = Modifier.padding(vertical = 14.dp), text = "Monthly Subscription")

                }
            }
        },

        confirmButton = {
            Button(

                onClick = {
                    showDialog.value = false
                    onAddCharityClick
                }) {
                Text("Add Theme")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    showDialog.value = false
                }) {
                Text("Cancel")
            }
        }
    )
}

@Preview
@Composable
private fun PreviewHeaderLight() {
    KindTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            Header()
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewHeaderDark() {
    KindTheme {
        Box(Modifier.background(MaterialTheme.colorScheme.background)) {
            Header()
        }
    }
}
/*
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

 */