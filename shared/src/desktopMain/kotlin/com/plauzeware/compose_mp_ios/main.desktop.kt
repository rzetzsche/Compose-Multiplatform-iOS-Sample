package com.plauzeware.compose_mp_ios

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.plauzeware.compose_mp_ios.screens.MainScreen
import com.plauzeware.compose_mp_ios.screens.SecondScreen

@Composable
fun MainDesktopView() {
    App()
}

@Composable
@Preview
fun PreviewMain() {
    MainScreen {  }
}

@Composable
@Preview
fun PreviewSecond() {
    SecondScreen {  }
}