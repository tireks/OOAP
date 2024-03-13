package com.tirexmurina.singleton.presentation

import androidx.lifecycle.ViewModel
import com.tirexmurina.singleton.domain.entity.Note

class EditViewModel() : ViewModel() {

    private val database = com.tirexmurina.singleton.data.NoteDatabase

    fun getNoteById(id: String) : Note? {
        return database.getNoteById(id)
    }

}