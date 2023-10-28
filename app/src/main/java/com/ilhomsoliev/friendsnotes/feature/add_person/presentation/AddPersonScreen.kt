package com.ilhomsoliev.friendsnotes.feature.add_person.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel.AddPersonViewModel
import com.ilhomsoliev.friendsnotes.shared.model.PersonType
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun NavGraphBuilder.AddPersonScreenComposable(navController: NavController) {
    composable(route = Screens.AddPersonScreen.route) {
        AddPersonScreen(
            vm = koinViewModel(),
            goToMainScreen = {
                navController.navigate(Screens.MainScreen.route)
            },
        ) {
            navController.navigateUp()
        }
    }
}

@Composable
fun AddPersonScreen(
    vm: AddPersonViewModel,
    goToMainScreen: () -> Unit,
    popBack: () -> Unit,
) {
    val currentStep by vm.currentStep.collectAsState()
    val personType by vm.personType.collectAsState()
    val personName by vm.personName.collectAsState()
    val favoriteFood by vm.favoriteFood.collectAsState()
    val dislikedThings by vm.dislikedThings.collectAsState()
    val notes by vm.notes.collectAsState()
    val dateOfBirth by vm.dateOfBirth.collectAsState()

    LaunchedEffect(key1 = currentStep, block = {
        if (currentStep == 6) {
            goToMainScreen()
        }
    })
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
        dateOfBirth = if (dateOfBirth != null) SimpleDateFormat(
            "yyyy-MM-dd",
            Locale.ROOT
        ).format(Date(dateOfBirth!!)) else "",
        favoriteFood = favoriteFood,
        dislikedThings = dislikedThings,
        notes = notes,
        isCurrentButtonActive = isButtonActive,
    ), callback = object : AddPersonCallback {
        override fun onNextClick() {
            if (isButtonActive) {
                vm.onNextScreen()
            } else {
                // TODO Show Snackbar
            }
        }

        override fun onBack() {
            if (currentStep == 1) popBack()
            else vm.onPrevScreen()
        }

        override fun onPersonTypeChange(personType: PersonType) {
            vm.onPersonTypeChange(personType)
        }

        override fun onPersonNameChange(value: String) {
            vm.onPersonNameChange(value)
        }

        override fun onSelectBirthDate(value: Long) {
            vm.onDateOfBirthChange(value)
        }

    })

}