package com.ilhomsoliev.friendsnotes.data.repository

import com.ilhomsoliev.friendsnotes.data.dao.PersonDao
import com.ilhomsoliev.friendsnotes.shared.model.PersonType
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import com.ilhomsoliev.friendsnotes.shared.model.person.map

class PersonRepository(
    private val dao: PersonDao
) {
    suspend fun addPerson(personModel: PersonModel) {
        dao.insert(personModel.map())
    }

    suspend fun getPersonById(personId: Int) = dao.getPersonById(personId)?.map()
    fun getPeople() = dao.getPersons(null)

    fun getFriends() = dao.getPersons(PersonType.FRIEND)

    fun getRelatives() = dao.getPersons(PersonType.RELATIVE)

    fun getLovely() = dao.getPersons(PersonType.LOVELY)
    suspend fun deletePerson(personModel: PersonModel) {
        dao.delete(personModel.map())
    }

}