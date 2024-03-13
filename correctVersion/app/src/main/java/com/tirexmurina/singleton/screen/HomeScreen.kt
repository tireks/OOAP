package com.tirexmurina.singleton.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tirexmurina.singleton.R
import com.tirexmurina.singleton.domain.entity.Note
import com.tirexmurina.singleton.presentation.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel(),
               onNoteClick: (String) -> Unit
){
    val notesList = homeViewModel.list
    HomeScreenContent(
        notesList = notesList,
        dbId = homeViewModel.dbId,
        onAddClick = { homeViewModel.addNote() },
        onDeleteClick = {},
        onNoteClick = { onNoteClick(it) }
    )
}

@Composable
fun HomeScreenContent(
    notesList: SnapshotStateList<Note>,
    dbId: String,
    onAddClick: () -> Unit,
    onDeleteClick: (String) -> Unit,
    onNoteClick: (String) -> Unit

){
    Column (){
        Row (
            modifier = Modifier.padding(
                start = 8.dp,
                end = 8.dp
            )
        ){
            Text(
                text = "DB id:",
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(text = dbId)
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ){
            items(notesList) { item ->
                SingleNoteItem(
                    note = item,
                    onDeleteClick = { onDeleteClick(it) },
                    onNoteClick = {onNoteClick(it)}
                )
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
            onClick = { onAddClick() }
        ) {
            Text(
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp
                ),
                text = "Add",
                fontSize = 18.sp, fontWeight = FontWeight.Medium, fontStyle = FontStyle.Italic

            )
        }
    }

}

@Composable
fun SingleNoteItem(
    note: Note,
    onDeleteClick: (String) -> Unit,
    onNoteClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onNoteClick(note.id) }
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(10.dp),

        ){
        Column(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = { onDeleteClick(note.id) },
                modifier = Modifier
                    .align(Alignment.End)
                    .size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_note),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.End)
                )
            }
            Text(
                text = note.title,

                fontSize = 18.sp, fontWeight = FontWeight.Medium, fontStyle = FontStyle.Italic
            )
            Text(
                text = note.content,
                fontSize = 12.sp, maxLines = 4, overflow = TextOverflow.Ellipsis
            )
        }
    }
}