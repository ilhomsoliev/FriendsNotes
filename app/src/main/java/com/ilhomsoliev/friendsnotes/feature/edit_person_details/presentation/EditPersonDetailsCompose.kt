package com.ilhomsoliev.friendsnotes.feature.edit_person_details.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.feature.person_details.presentation.components.PersonDetailsDataItem
import com.ilhomsoliev.friendsnotes.shared.CustomTopBar
import com.ilhomsoliev.friendsnotes.shared.buttons.CustomButton
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonsDataTypes
import com.ilhomsoliev.friendsnotes.shared.model.person.getEditDataTitleForPersonsDataType

data class EditPersonDetailsState(
    val person: PersonModel?,
    val personData: PersonsDataTypes?,
)

interface EditPersonDetailsCallback {
    fun onBackClick()
    fun onEditValue(value: String)
    fun onSave()
}


@Composable
fun EditPersonDetailsContent(
    state: EditPersonDetailsState,
    callback: EditPersonDetailsCallback,
) {
    if (state.personData != null && state.person != null) {
        Scaffold(topBar = {
            CustomTopBar(title = getEditDataTitleForPersonsDataType(
                state.personData,
                state.person.name.value
            ),
                actionIcon = Icons.Default.Cancel, onBackClick = {
                    callback.onBackClick()
                }, onActionClick = {

                })
        }) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(it)
                    .padding(horizontal = 20.dp)
            ) {
                PersonDetailsDataItem(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 28.dp),
                    title = "Date of birth",
                    value = state.personData,
                    onValueChange = {
                        callback.onEditValue(it)
                    }, isReadOnly = false
                )

                CustomButton(text = "Save") {
                    callback.onSave()
                }
            }

        }

    }
}