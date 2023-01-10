package com.plauzeware.compose_mp_ios

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow

fun main() = application {
    PreComposeWindow(onCloseRequest = { exitApplication() }) {
        MaterialTheme {
            MainDesktopView()
        }
    }
} 