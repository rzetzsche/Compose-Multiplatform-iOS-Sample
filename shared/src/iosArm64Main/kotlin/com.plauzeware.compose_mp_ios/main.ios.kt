package com.plauzeware.compose_mp_ios

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController =
    PreComposeApplication("SampleApp") {
        Column {
            Box(modifier = Modifier.height(30.dp))
            App()
        }
    }
