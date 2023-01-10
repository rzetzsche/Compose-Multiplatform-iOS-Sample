package com.plauzeware.compose_mp_ios.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
internal fun SecondScreen(goBack: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Second Screen") },
            navigationIcon = {
                IconButton(
                    onClick = goBack,
                    content = { Icon(Icons.Filled.ArrowBack, "") }
                )
            })
    }) {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "This is the second Screen!"
            )
            Box(modifier = Modifier.height(30.dp))
            Button(onClick = goBack, content = { Text("Go Back") })
        }
    }
}
