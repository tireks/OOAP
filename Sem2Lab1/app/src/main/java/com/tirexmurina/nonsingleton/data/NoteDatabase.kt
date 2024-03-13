package com.tirexmurina.nonsingleton.data

import com.tirexmurina.nonsingleton.domain.entity.Note
import com.tirexmurina.nonsingleton.utils.getRandomString
import kotlin.random.Random

class NoteDatabase {

    private val contentList: MutableList<Note> = mutableListOf()

    private val classId = getRandomString(4)

    public fun add(note: Note){
        contentList.add(note)
    }

    public fun showContent() : MutableList<Note>{
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