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
import com.ilhomsoliev.friendsnotes.shared.textfield.CustomTextFieldMultipleLines

@Composable
fun Step4FoodComponent(
    personName: String,
    text: String,
    onValueChange: (String) -> Unit,
) {

    Text(
        text = "$personName's favorite food",
        style = MaterialTheme.typography.titleLarge
    )

    Spacer(modifier = Modifier.height(32.dp))
    CustomTextFieldMultipleLines(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        hint = "Please indicate [name]'s favorite food\u2028example: strawberries, carrots, cheesecake, etc. \n",
        text = text,
        onValueChange = onValueChange
    )
}