package com.ilhomsoliev.friendsnotes.feature.add_person.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.AddPersonTopBar
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step1TypeComponent
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step2NameComponent
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step3BirthdayComponent
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step4FoodComponent
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step5DislikedComponent
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.components.Step6NotesComponent
import com.ilhomsoliev.friendsnotes.shared.buttons.CustomButton
import com.ilhomsoliev.friendsnotes.shared.model.PersonType

data class AddPersonState(
    val personType: PersonType?,
    val currentStep: Int,
    val name: String,
    val dateOfBirth: String,
    val favoriteFood: String,
    val dislikedThings: String,
    val notes: String,
    val isCurrentButtonActive: Boolean,
)

interface AddPersonCallback {
    fun onNextClick()
    fun onBack()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPersonContent(
    state: AddPersonState,
    callback: AddPersonCallback,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        AddPersonTopBar(currentStep = state.currentStep) {
            callback.onBack()
        }
    }, bottomBar = {
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 64.dp),
            text = "Next",
            isActive = state.isCurrentButtonActive
        ) {
            callback.onNextClick()
        }
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), contentAlignment = Alignment.Center
        ) {
            AnimatedContent(targetState = state.currentStep, label = "") {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (it) {
                        1 -> Step1TypeComponent()
                        2 -> Step2NameComponent()
                        3 -> Step3BirthdayComponent()
                        4 -> Step4FoodComponent()
                        5 -> Step5DislikedComponent()
                        6 -> Step6NotesComponent()
                    }
                }
            }
        }
    }

}