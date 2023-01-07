package com.plauzeware.compose_mp_ios

import androidx.compose.runtime.Composable
import com.plauzeware.compose_mp_ios.screens.MainScreen
import com.plauzeware.compose_mp_ios.screens.SecondScreen
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
internal fun App() {
    val navigator = rememberNavigator()
    NavHost(
        navigator = navigator,
        navTransition = NavTransition(),
        initialRoute = "/home",
    ) {
        scene(
            route = "/home",
            navTransition = NavTransition(),
        ) {
            MainScreen(onNavigate = { navigator.navigate("/second") })
        }
        scene(
            route = "/second",
            navTransition = NavTransition(),
        ) {
            SecondScreen(goBack = { navigator.goBack() })
        }
    }
}