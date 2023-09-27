package com.ilhomsoliev.friendsnotes.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ilhomsoliev.friendsnotes.data.dao.ext.BaseDao
import com.ilhomsoliev.friendsnotes.data.model.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao : BaseDao<NoteEntity> {
    @Query("SELECT * FROM `note` WHERE personId = :personId")
    fun getNotesByPersonId(personId: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM `note` WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): NoteEntity?
}