package com.tirexmurina.nonsingleton.domain.usecase

import com.tirexmurina.nonsingleton.domain.entity.Note
import com.tirexmurina.nonsingleton.domain.repository.NoteRepository

class DeleteNoteUseCase (
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: String) = repository.deleteNoteById(id)
}