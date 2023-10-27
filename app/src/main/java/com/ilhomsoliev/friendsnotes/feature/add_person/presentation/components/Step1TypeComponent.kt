package com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Step1TypeComponent() {

    Text(
        text = "Choose who we will build relationships with",
        style = MaterialTheme.typography.titleLarge
    )


}