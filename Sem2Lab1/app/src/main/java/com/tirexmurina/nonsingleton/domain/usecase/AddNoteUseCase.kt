package com.tirexmurina.nonsingleton.domain.usecase

import com.tirexmurina.nonsingleton.domain.entity.Note
import com.tirexmurina.nonsingleton.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.addNote(note)
}