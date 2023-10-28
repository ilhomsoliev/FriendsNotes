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
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomTextField

@Composable
fun Step2NameComponent(
    text: String,
    onValueChange: (String) -> Unit,
) {
    Text(
        text = "Person's favorite message",
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(32.dp))
    CustomTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        hint = "Enter the name",
        text = text,
        onValueChange = onValueChange
    )
}