package com.plauzeware.compose_mp_ios.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
internal fun MainScreen(onNavigate: () -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Main Screen") }) }) {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "This is a first Sample App of Kotlin Multiplatform including compose for iOS!"
            )
            Box(modifier = Modifier.height(30.dp))
            Button(onClick = onNavigate, content = { Text("Navigate to next page") })
        }
    }
}
