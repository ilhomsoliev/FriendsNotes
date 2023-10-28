package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomTextFieldMultipleLines

@Composable
fun Step6NotesComponent(
    personName: String,
    text: String,
    onValueChange: (String) -> Unit,
) {
    Text(
        text = "Notes about the $personName",
        style = MaterialTheme.typography.titleLarge
    )

    Spacer(modifier = Modifier.height(32.dp))

    CustomTextFieldMultipleLines(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        hint = "Write a note the $personName",
        text = text,
        onValueChange = onValueChange
    )

}