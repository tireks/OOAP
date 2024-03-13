package com.tirexmurina.nonsingleton.domain.repository

import com.tirexmurina.nonsingleton.domain.entity.Note

interface NoteRepository {

    suspend fun getNotes() : MutableList<Note>

    suspend fun addNote(note: Note)

    suspend fun deleteNoteById(id: String)


}