package com.ilhomsoliev.friendsnotes.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.ilhomsoliev.friendsnotes.data.dao.ext.BaseDao
import com.ilhomsoliev.friendsnotes.data.model.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao /*: BaseDao<PersonEntity> */{
    @Query("SELECT * FROM `person`")
    fun getPersons(): Flow<List<PersonEntity>>

    /*@Query("SELECT * FROM `person` WHERE id = :personId")
    suspend fun getPersonById(personId: Int): PersonEntity?*/

}