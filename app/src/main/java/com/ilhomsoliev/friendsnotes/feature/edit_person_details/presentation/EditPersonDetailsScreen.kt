package com.ilhomsoliev.friendsnotes.feature.edit_person_details.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.edit_person_details.viewmodel.EditPersonDetailsViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.EditPersonDetailsComposable(navController: NavController) {
    composable(route = Screens.EditPersonDetailsScreen.route) {
        val personId = Screens.EditPersonDetailsScreen.getPersonId(it)
        EditPersonDetailsScreen(
            vm = koinViewModel(),
            personId = personId,
            onBack = {
                navController.popBackStack()
            }
        )
    }
}

@Composable
fun EditPersonDetailsScreen(
    vm: EditPersonDetailsViewModel,
    personId: Int,
    onBack: () -> Unit
) {
    val person by vm.person.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        vm.loadPerson(personId)
    })
    EditPersonDetailsContent(
        state = EditPersonDetailsState(person = person),
        object : EditPersonDetailsCallback {
            override fun onBackClick() {
                onBack()
            }
        }
    )
}