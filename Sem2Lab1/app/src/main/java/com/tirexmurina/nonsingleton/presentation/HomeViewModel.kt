package com.tirexmurina.nonsingleton.presentation

import androidx.lifecycle.ViewModel
import com.tirexmurina.nonsingleton.data.NoteDatabase
import com.tirexmurina.nonsingleton.domain.entity.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val database = NoteDatabase()
    private val _list = MutableStateFlow(database.showContent())
    val list: StateFlow<MutableList<Note>> = _list

    init {
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa1",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa2",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
        _list.value.add(Note(
            id = "sasa",
            title = "LoremNote",
            content = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."),
        )
    }

}