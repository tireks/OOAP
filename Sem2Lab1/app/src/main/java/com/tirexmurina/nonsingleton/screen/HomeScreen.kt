package com.tirexmurina.nonsingleton.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tirexmurina.nonsingleton.R
import com.tirexmurina.nonsingleton.domain.entity.Note
import com.tirexmurina.nonsingleton.presentation.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
){
    val notesList by homeViewModel.list.collectAsState()
    HomeScreenContent(notesList = notesList)
}

@Composable
fun HomeScreenContent(
    notesList: MutableList <Note>
){
    Column (){
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ){
            items(notesList) { item ->
                SingleNoteItem(note = item)
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
            onClick = { /*TODO*/ }
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
fun SingleNoteItem(note: Note) {
    Card(
        modifier = Modifier
            .padding(8.dp)
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
                onClick = { /*TODO*/ },
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
                fontSize = 12.sp, maxLines = 2, overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen(){
    /*SingleNoteItem(note = Note(
        id = "sas",
        title = "SasNote",
        content = "SasContent34345235455f2454f4g23443f34g2f435g23424g2f34333333333333333333333333333333333333333333333333333333333333333333333"
    ))*/
    HomeScreenContent(notesList = mutableListOf<Note>(
        Note(id = "sas",
            title = "SasNote",
            content = "SasContent"),
        Note(id = "sasa",
            title = "SasNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.")
    )
    )
}