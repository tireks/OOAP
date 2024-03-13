package com.tirexmurina.singleton.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tirexmurina.singleton.presentation.EditViewModel

@Composable
fun EditScreen(
    id : String?,
    backNavigation: () -> Unit,
    viewModel: EditViewModel = viewModel()
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
            val noteId = viewModel.getNoteById(id)
            if (noteId != null){
                Text(text = noteId.id,
                        modifier = Modifier.padding(end = 16.dp)
                )
                Text(text = noteId.title,
                    modifier = Modifier.padding(end = 16.dp)
                )
            }

        }
    }
    BackHandler {
        backNavigation()
    }
}