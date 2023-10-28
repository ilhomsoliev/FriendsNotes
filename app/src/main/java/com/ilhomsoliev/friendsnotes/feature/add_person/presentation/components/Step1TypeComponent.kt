package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.shared.buttons.CustomButton
import com.ilhomsoliev.friendsnotes.shared.model.PersonType

@Composable
fun Step1TypeComponent(
    activePersonType: PersonType?,
    onPersonTypeClick: (PersonType) -> Unit,
) {
    val buttonModifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp)
        .padding(bottom = 8.dp)
    Text(
        text = "Choose who we will build relationships with",
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(32.dp))
    CustomButton(
        modifier = buttonModifier,
        text = "Lovely",
        isActive = activePersonType == PersonType.LOVELY,
        textColor = Color(0xFF040F23)
    ) {
        onPersonTypeClick(PersonType.LOVELY)
    }
    CustomButton(
        modifier = buttonModifier,
        text = "Relative",
        isActive = activePersonType == PersonType.RELATIVE,
        textColor = Color(0xFF040F23)
    ) {
        onPersonTypeClick(PersonType.RELATIVE)
    }
    CustomButton(
        modifier = buttonModifier,
        text = "Friend",
        isActive = activePersonType == PersonType.FRIEND,
        textColor = Color(0xFF040F23)
    ) {
        onPersonTypeClick(PersonType.FRIEND)
    }
}