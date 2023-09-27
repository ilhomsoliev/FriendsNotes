package com.ilhomsoliev.friendsnotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,

)