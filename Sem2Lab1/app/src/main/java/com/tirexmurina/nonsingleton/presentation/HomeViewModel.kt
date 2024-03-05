package com.tirexmurina.nonsingleton.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.tirexmurina.nonsingleton.data.NoteDatabase
import com.tirexmurina.nonsingleton.domain.entity.Note
import com.tirexmurina.nonsingleton.utils.getRandomString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val database = NoteDatabase()

    val list = mutableStateListOf<Note>()
    val dbId = database.showId()


    init {
        database.showContent().forEach{
            list.add(it)
        }
    }

    fun addNote(){
        val note = Note(
            id = getRandomString(10),
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
        )
        database.add(note)
        list.add(note)
        //list.add(note)
        Log.d("BK", "element added: ${note.id}")
        Log.d("BK", "list: ${list.size}")
    }





}