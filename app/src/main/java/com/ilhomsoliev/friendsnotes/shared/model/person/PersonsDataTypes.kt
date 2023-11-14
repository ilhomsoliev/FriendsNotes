package com.ilhomsoliev.friendsnotes.shared.model.person

sealed class PersonsDataTypes(
    val id: String,
) {
    companion object {
        fun getPersonsDataTypeById(id: String, personModel: PersonModel) = when (id) {
            "Name" -> personModel.name
            "DateOfBirth" -> personModel.dateOfBirth
            "FavoriteFood" -> personModel.favoriteFood
            "DislikedThings" -> personModel.dislikedThings
            "Notes" -> personModel.notes
            else -> null
        }
    }

    data class Name(val value: String) : PersonsDataTypes("Name")
    data class DateOfBirth(val value: Long, val strValue: String) : PersonsDataTypes("DateOfBirth")
    data class FavoriteFood(val value: String) : PersonsDataTypes("FavoriteFood")
    data class DislikedThings(val value: String) : PersonsDataTypes("DislikedThings")
    data class Notes(val value: String) : PersonsDataTypes("Notes")

}

fun getEditDataTitleForPersonsDataType(personsDataTypes: PersonsDataTypes, personName: String) =
    when (personsDataTypes) {
        is PersonsDataTypes.Name -> "Rename $personName's name"
        is PersonsDataTypes.DateOfBirth -> "$personName's birthday"
        is PersonsDataTypes.FavoriteFood -> "$personName's favorite food"
        is PersonsDataTypes.DislikedThings -> "$personName's disliked things"
        is PersonsDataTypes.Notes -> "Notes about the $personName"

    }