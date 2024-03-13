package com.tirexmurina.singleton.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditScreen(
    id : String?,
    backNavigation: () -> Unit
){
    Row (
        modifier = Modifier.padding(
            start = 8.dp,
            end = 8.dp
        )
    ){
        Text(
            text = "Note id:",
            modifier = Modifier.padding(end = 16.dp)
        )
        if (id != null) {
            Text(text = id)
        }
    }
    BackHandler {
        backNavigation()
    }
}