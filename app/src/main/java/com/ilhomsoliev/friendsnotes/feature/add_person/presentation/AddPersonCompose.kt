package com.ilhomsoliev.friendsnotes.feature.add_person.presentation

import androidx.compose.runtime.Composable
import com.ilhomsoliev.friendsnotes.shared.model.PersonType

data class AddPersonState(
    val personType: PersonType?,
    val currentStep: Int,
    val name: String,
    val dateOfBirth: String,
    val favoriteFood: String,
    val dislikedThings: String,
    val notes: String,
    val isCurrentButtonActive: Boolean,
)

interface AddPersonCallback {
    fun onNextClick()

}

@Composable
fun AddPersonContent(
    state: AddPersonState,
    callback: AddPersonCallback,
) {

}