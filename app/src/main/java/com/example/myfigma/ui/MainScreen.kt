package com.example.myfigma.ui

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.myfigma.ScreenContent

class MainScreen : Screen {
    @Composable
    override fun Content() {
        ScreenContent()
    }

}