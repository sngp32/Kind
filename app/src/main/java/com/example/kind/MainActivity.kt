package com.example.kind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kind.controller.Navigation
import com.example.kind.ui.theme.KindTheme
import com.example.kind.view.SettingsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KindTheme {
              Navigation()
            }
        }
    }
}
