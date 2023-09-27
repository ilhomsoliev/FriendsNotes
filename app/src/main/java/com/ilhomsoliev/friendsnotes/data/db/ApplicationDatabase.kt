package com.ilhomsoliev.friendsnotes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ilhomsoliev.friendsnotes.data.dao.NoteDao
import com.ilhomsoliev.friendsnotes.data.dao.PersonDao
import com.ilhomsoliev.friendsnotes.data.model.NoteEntity
import com.ilhomsoliev.friendsnotes.data.model.PersonEntity

@Database(
    entities = [NoteEntity::class, PersonEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun noteDao(): NoteDao
}

fun getDatabaseInstance(context: Context) =
    Room.databaseBuilder(context, ApplicationDatabase::class.java, "notes_database")
        .fallbackToDestructiveMigration()
        .build()
