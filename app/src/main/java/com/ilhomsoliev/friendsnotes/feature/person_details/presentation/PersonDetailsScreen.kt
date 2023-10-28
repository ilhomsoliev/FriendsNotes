package com.ilhomsoliev.friendsnotes.feature.person_details.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.person_details.viewmodel.PersonDetailsViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.PersonDetailsComposable(navController: NavController) {
    composable(route = Screens.PersonDetailsScreen.route) {
        val personId = Screens.PersonDetailsScreen.getPersonId(it)
        PersonDetailsScreen(
            vm = koinViewModel(),
            personId = personId,
            onBack = {
                navController.popBackStack()
            }
        )
    }
}

@Composable
fun PersonDetailsScreen(
    vm: PersonDetailsViewModel,
    personId: Int,
    onBack: () -> Unit,
) {
    val person by vm.person.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        vm.loadPerson(personId)
    })

    PersonDetailsContent(state = PersonDetailsState(person), object : PersonDetailsCallback {
        override fun onBackClick() {
            onBack()
        }

        override fun onDeleteClick() {
            TODO("Not yet implemented")
        }

    })
}