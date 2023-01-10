package com.example.kind.ui.utils

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

/**
 * Add this multipreview annotation to a composable to render
 * the composable in light theme and dark theme
 */

@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_YES,
)
@Preview(
    name = "light theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_NO,
)
annotation class ThemePreviews

@Preview(
    name = "dark theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF1A1C19
)
@Preview(
    name = "light theme",
    group = "themes",
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
    backgroundColor = 0xFFFCFDF6
)
annotation class BackgroundThemeCombinedPreviews





