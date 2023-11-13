package com.ilhomsoliev.friendsnotes.shared.model.person

import com.ilhomsoliev.friendsnotes.core.formatMillisToDateString
import com.ilhomsoliev.friendsnotes.data.model.PersonEntity
import com.ilhomsoliev.friendsnotes.shared.model.PersonType

data class PersonModel(
    val id: Int?,
    val name: PersonsDataTypes.Name,
    val type: PersonType,
    val dateOfBirth: PersonsDataTypes.DateOfBirth,
    val favoriteFood: PersonsDataTypes.FavoriteFood,
    val dislikedThings: PersonsDataTypes.DislikedThings,
    val notes: PersonsDataTypes.Notes,
) {
    fun map(): PersonEntity = PersonEntity(
        id = id,
        name = name.value,
        type = type.name,
        dateOfBirth = dateOfBirth.value,
        favoriteFood = favoriteFood.value,
        dislikedThings = dislikedThings.value,
        notes = notes.value,
    )
}

fun PersonEntity.map(): PersonModel = PersonModel(
    id = id,
    name = PersonsDataTypes.Name(name),
    type = PersonType.valueOf(type),
    dateOfBirth = PersonsDataTypes.DateOfBirth(dateOfBirth, formatMillisToDateString(dateOfBirth)),
    favoriteFood =PersonsDataTypes.FavoriteFood(favoriteFood),
    dislikedThings = PersonsDataTypes.DislikedThings(dislikedThings),
    notes = PersonsDataTypes.Notes(notes),
)