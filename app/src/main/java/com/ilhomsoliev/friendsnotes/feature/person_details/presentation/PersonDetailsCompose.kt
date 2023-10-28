package com.ilhomsoliev.friendsnotes.feature.person_details.presentation

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.MainTitle
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.NoteItem
import com.ilhomsoliev.friendsnotes.feature.person_details.presentation.components.PersonDetailsDataItem
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
    state.person?.let { person ->
        Scaffold(topBar = {
            PersonDetailsTopBar(title = person.name, onBackClick = {
                callback.onBackClick()
            }, onDeleteClick = {
                callback.onDeleteClick()
            })
        }) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .padding(horizontal = 20.dp)
            ) {
                item(key = 1) {
                    MainTitle(modifier = Modifier, text = person.type.name)
                }
                item(key = 2) {
                    NoteItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1.8f)
                            .padding(vertical = 16.dp),
                        text = person.name,
                        gradientColors = listOf(
                            Color(0xFFFFF5C9),
                            Color(0xFFFFEBEC),
                        ),
                    )
                }
                item(key = 3) {
                    PersonDetailsDataItem(
                        title = "Date of birth",
                        value = person.dateOfBirth.toString(),
                        onClick = {

                        })
                }
                item(key = 4) {
                    PersonDetailsDataItem(
                        title = "Favorite food",
                        value = person.favoriteFood,
                        isMultipleLines = true,
                        onClick = {

                        })
                }
                item(key = 5) {
                    PersonDetailsDataItem(
                        title = "What doesn’t like?",
                        value = person.dislikedThings,
                        isMultipleLines = true,
                        onClick = {

                        })
                }
                item(key = 6) {
                    PersonDetailsDataItem(
                        title = "Notes about the",
                        value = person.notes,
                        isMultipleLines = true,
                        onClick = {

                        })
                }
            }
        }
    }
}