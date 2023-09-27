package com.ilhomsoliev.friendsnotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val personId:String,
    val description:String,
)