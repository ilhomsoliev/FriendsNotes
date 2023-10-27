package com.ilhomsoliev.friendsnotes.feature.add_person.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel.AddPersonViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.AddPersonScreenComposable(navController: NavController) {
    composable(route = Screens.AddPersonScreen.route) {
        AddPersonScreen(vm = koinViewModel())
    }
}
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

    val isButtonActive = when (currentStep) {
        1 -> personType != null
        2 -> personName.isNotEmpty()
        3 -> dateOfBirth != null
        4 -> favoriteFood.isNotEmpty()
        5 -> dislikedThings.isNotEmpty()
        6 -> notes.isNotEmpty()
        else -> false
    }
    AddPersonContent(state = AddPersonState(
        personType = personType,
        currentStep = currentStep,
        name = personName,
        dateOfBirth = dateOfBirth.toString(),
        favoriteFood = favoriteFood,
        dislikedThings = dislikedThings,
        notes = notes,
        isCurrentButtonActive = isButtonActive,
    ), callback = object : AddPersonCallback {
        override fun onNextClick() {
            TODO("Not yet implemented")
        }

    })

}