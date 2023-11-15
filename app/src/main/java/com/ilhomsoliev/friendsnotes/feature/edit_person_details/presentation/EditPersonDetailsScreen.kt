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
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonsDataTypes
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.EditPersonDetailsComposable(navController: NavController) {
    composable(route = Screens.EditPersonDetailsScreen.route) {
        val personId = Screens.EditPersonDetailsScreen.getPersonId(it)
        val personDataId = Screens.EditPersonDetailsScreen.getPersonDataId(it)

        EditPersonDetailsScreen(
            vm = koinViewModel(),
            personId = personId,
            personDataId,
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
    personDataId: String,
    onBack: () -> Unit
) {
    val person by vm.person.collectAsState()
    // val personsDataType by vm.personsDataType.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        vm.loadPerson(personId, personDataId)
    })

    EditPersonDetailsContent(
        state = EditPersonDetailsState(
            person = person,
            personData = person?.let { PersonsDataTypes.getPersonsDataTypeById(personDataId, it) },
        ),
        object : EditPersonDetailsCallback {
            override fun onBackClick() {
                onBack()
            }

            override fun onEditValue(value: String) {
                TODO("Not yet implemented")
            }

            override fun onSave() {
                TODO("Not yet implemented")
            }
        }
    )
}