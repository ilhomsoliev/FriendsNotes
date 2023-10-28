package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomDatePicker
import java.time.Instant
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Step3BirthdayComponent(
    personName: String,
    selectedDate: String,
    onSelectDate: (Long) -> Unit,
) {
    val calendar = Calendar.getInstance()
    calendar.set(2010, 0, 22) // add year, month (Jan), date

    // set the initial date
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    val isDialogActive = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = datePickerState.selectedDateMillis, block = {
        if (isDialogActive.value) {
            datePickerState.selectedDateMillis?.let {
                onSelectDate(it)
                isDialogActive.value = false
            }
        }
    })

    Text(
        text = "Please indicate $personName’s date of birth",
        style = MaterialTheme.typography.titleLarge
    )

    Spacer(modifier = Modifier.height(32.dp))

    CustomDatePicker(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        hint = "Select date of birth",
        text = selectedDate
    ) {
        isDialogActive.value = true
    }


    if (isDialogActive.value) {
        DatePickerDialog(onDismissRequest = {
            isDialogActive.value = false
        }, confirmButton = {
            // isDialogActive.value = false
        }) {
            DatePicker(
                state = datePickerState,
            )
        }
    }


}