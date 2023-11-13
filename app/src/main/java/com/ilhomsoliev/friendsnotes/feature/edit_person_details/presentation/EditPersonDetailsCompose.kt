package com.ilhomsoliev.friendsnotes.feature.edit_person_details.presentation

import androidx.compose.runtime.Composable
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel

data class EditPersonDetailsState(
    val person: PersonModel?,
)

interface EditPersonDetailsCallback {
    fun onBackClick()
}


@Composable
fun EditPersonDetailsContent(
    state: EditPersonDetailsState,
    callback: EditPersonDetailsCallback,
) {


}