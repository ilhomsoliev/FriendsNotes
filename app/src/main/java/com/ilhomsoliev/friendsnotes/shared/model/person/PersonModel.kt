package com.ilhomsoliev.friendsnotes.shared.model.person

import com.ilhomsoliev.friendsnotes.data.model.PersonEntity
import com.ilhomsoliev.friendsnotes.shared.model.PersonType

data class PersonModel(
    val id: Int?,
    val name: String,
    val type: PersonType,
    val dateOfBirth: Long,
    val favoriteFood: String,
    val dislikedThings: String,
    val notes: String,
) {
    fun map(): PersonEntity = PersonEntity(
        id = id,
        name = name,
        type = type.name,
        dateOfBirth = dateOfBirth,
        favoriteFood = favoriteFood,
        dislikedThings = dislikedThings,
        notes = notes,
    )
}

fun PersonEntity.map(): PersonModel = PersonModel(
    id = id,
    name = name,
    type = PersonType.valueOf(type),
    dateOfBirth = dateOfBirth,
    favoriteFood = favoriteFood,
    dislikedThings = dislikedThings,
    notes = notes,
)