package com.ilhomsoliev.friendsnotes.feature.person_details.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilhomsoliev.friendsnotes.R
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.MainTitle
import com.ilhomsoliev.friendsnotes.feature.main.presentation.components.NoteItem
import com.ilhomsoliev.friendsnotes.feature.person_details.presentation.components.PersonDetailsDataItem
import com.ilhomsoliev.friendsnotes.shared.CustomTopBar
import com.ilhomsoliev.friendsnotes.shared.buttons.CustomButton
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonsDataTypes

data class PersonDetailsState @OptIn(ExperimentalMaterial3Api::class) constructor(
    val person: PersonModel?,
    val isDeleteBsActive: Boolean,
    val sheetState: SheetState,
)

interface PersonDetailsCallback {
    fun onBackClick()
    fun onDeleteClick()
    fun onCancelInBsClick()
    fun onRemoveInBsClick()
    fun onEditClick(personsDataTypes: PersonsDataTypes)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailsContent(
    state: PersonDetailsState,
    callback: PersonDetailsCallback,
) {
    state.person?.let { person ->
        Scaffold(topBar = {
            CustomTopBar(title = person.name.value,
                actionIcon = Icons.Default.Delete,
                onBackClick = {
                    callback.onBackClick()
                }, onActionClick = {
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
                        text = person.name.value,
                        gradientColors = listOf(
                            Color(0xFFFFF5C9),
                            Color(0xFFFFEBEC),
                        )
                    )
                }
                item(key = 3) {
                    PersonDetailsDataItem(
                        title = "Date of birth",
                        value = person.dateOfBirth.strValue,
                        onClick = {
                            callback.onEditClick(person.dateOfBirth)
                        })
                }
                item(key = 4) {
                    PersonDetailsDataItem(
                        title = "Favorite food",
                        value = person.favoriteFood.value,
                        isMultipleLines = true,
                        onClick = {
                            callback.onEditClick(person.favoriteFood)
                        })
                }
                item(key = 5) {
                    PersonDetailsDataItem(
                        title = "What doesn’t like?",
                        value = person.dislikedThings.value,
                        isMultipleLines = true,
                        onClick = {
                            callback.onEditClick(person.dislikedThings)
                        })
                }
                item(key = 6) {
                    PersonDetailsDataItem(
                        title = "Notes about the",
                        value = person.notes.value,
                        isMultipleLines = true,
                        onClick = {
                            callback.onEditClick(person.notes)
                        })
                }
            }
        }
    }
    if (state.isDeleteBsActive)
        ModalBottomSheet(
            onDismissRequest = {
                callback.onCancelInBsClick()
            },
            sheetState = state.sheetState,
            shape = RoundedCornerShape(20.dp),
            containerColor = Color(0xFFFFFFFF),
            contentColor = Color(0xFFFFFFFF)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Remove ${state.person?.name}?",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 32.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(900),
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF212123),
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Cancel",
                isActive = false,
                textColor = Color(0xFF040F23),
                backgroundColor = Color(0xFFF1F2F4)
            ) {
                callback.onCancelInBsClick()
            }

            Spacer(modifier = Modifier.height(8.dp))

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), text = "Remove",
                backgroundColor = Color(0xFFEB5757)
            ) {
                callback.onRemoveInBsClick()
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
}