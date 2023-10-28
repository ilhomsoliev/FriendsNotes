package com.ilhomsoliev.friendsnotes.feature.person_details.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.ilhomsoliev.friendsnotes.feature.person_details.presentation.components.PersonDetailsTopBar
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel

data class PersonDetailsState(
    val person: PersonModel?,
)

interface PersonDetailsCallback {
    fun onBackClick()
    fun onDeleteClick()
}

@Composable
fun PersonDetailsContent(
    state: PersonDetailsState,
    callback: PersonDetailsCallback,
) {
    state.person?.let {
        Scaffold(topBar = {
            PersonDetailsTopBar(title = state.person.name, onBackClick = {
                callback.onBackClick()
            }, onDeleteClick = {
                callback.onDeleteClick()
            })
        }) {


        }
    }
}