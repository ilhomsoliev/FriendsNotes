package com.ilhomsoliev.friendsnotes.shared.model.person

sealed class PersonsDataTypes(
    val id: String,
) {
    data class Name(val value: String) : PersonsDataTypes("Name")
    data class DateOfBirth(val value: Long, val strValue: String) : PersonsDataTypes("DateOfBirth")
    data class FavoriteFood(val value: String) : PersonsDataTypes("FavoriteFood")
    data class DislikedThings(val value: String) : PersonsDataTypes("DislikedThings")
    data class Notes(val value: String) : PersonsDataTypes("Notes")

}