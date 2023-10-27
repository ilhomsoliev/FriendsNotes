package com.ilhomsoliev.friendsnotes.feature.add_person.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel.AddPersonViewModel

@Composable
fun AddPersonScreen(
    vm: AddPersonViewModel
) {
    val currentStep by vm.currentStep.collectAsState()
    val personType by vm.personType.collectAsState()
    val personName by vm.personName.collectAsState()
    val favoriteFood by vm.favoriteFood.collectAsState()
    val dislikedThings by vm.dislikedThings.collectAsState()
    val notes by vm.notes.collectAsState()
    val dateOfBirth by vm.dateOfBirth.collectAsState()

    AddPersonContent(state = AddPersonState(
        personType = personType,
        currentStep = currentStep,
        name = personName,
        dateOfBirth = dateOfBirth.toString(),
        favoriteFood = favoriteFood,
        dislikedThings = dislikedThings,
        notes = notes,
        isCurrentButtonActive = false,
    ), callback = object : AddPersonCallback {
        override fun onNextClick() {
            TODO("Not yet implemented")
        }

    })

}