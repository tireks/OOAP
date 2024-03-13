package com.tirexmurina.nonsingleton.domain.repository

import com.tirexmurina.nonsingleton.data.NoteDatabase
import com.tirexmurina.nonsingleton.domain.entity.Note

class NoteRepositoryImpl : NoteRepository{

    private val database = NoteDatabase()

    override suspend fun getNotes(): MutableList<Note> {
        return database.showContent()
    }

    override suspend fun addNote(note: Note) {
        database.add(note)
    }

    override suspend fun deleteNoteById(id: String) {
        database.delete(id)
    }


}