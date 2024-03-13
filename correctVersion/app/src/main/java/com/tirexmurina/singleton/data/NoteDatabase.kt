package com.tirexmurina.singleton.data

import com.tirexmurina.singleton.domain.entity.Note
import com.tirexmurina.singleton.utils.getRandomString

object NoteDatabase {
    private val contentList: MutableList<Note> = mutableListOf()

    private val classId = getRandomString(4)

    fun add(note: Note){
        contentList.add(note)
    }

    fun showContent() : MutableList<Note>{
        return contentList
    }

    public fun delete(id: String) {
        contentList.forEach{
            if (id == it.id){
                contentList.remove(it)
            }
        }
    }

    public fun getNoteById(id: String) : Note?{
        try {
            contentList.forEach {
                if (it.id == id){
                    return it
                }
            }
            throw Exception()
        } catch (e:Exception){
            return null
        }
    }

    public fun showId() : String{
        return classId
    }
}