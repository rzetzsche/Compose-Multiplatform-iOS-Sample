package com.plauzeware.compose_mp_ios

import androidx.compose.material.MaterialTheme
import moe.tlaster.precompose.PreComposeWindow

fun main() = PreComposeWindow(onCloseRequest = {}) {
    MaterialTheme {
        MainDesktopView()
    }
}
