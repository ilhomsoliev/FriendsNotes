package com.ilhomsoliev.friendsnotes.feature.person_details.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.person_details.viewmodel.PersonDetailsViewModel
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonsDataTypes
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.PersonDetailsComposable(navController: NavController) {
    composable(route = Screens.PersonDetailsScreen.route) {
        val personId = Screens.PersonDetailsScreen.getPersonId(it)
        PersonDetailsScreen(
            vm = koinViewModel(),
            personId = personId,
            onEditPersonDataClick = { personDataId ->
                navController.navigate(
                    Screens.EditPersonDetailsScreen.buildRoute(
                        personId = personId,
                        personDataId = personDataId
                    )
                )
            },
            onBack = {
                navController.popBackStack()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonDetailsScreen(
    vm: PersonDetailsViewModel,
    personId: Int,
    onEditPersonDataClick: (String) -> Unit,
    onBack: () -> Unit,
) {
    val person by vm.person.collectAsState()
    var isDeleteBsActive by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit, block = {
        vm.loadPerson(personId)
    })

    PersonDetailsContent(
        state = PersonDetailsState(person, isDeleteBsActive, sheetState),
        object : PersonDetailsCallback {
            override fun onBackClick() {
                onBack()
            }

            override fun onDeleteClick() {
                isDeleteBsActive = true
            }

            override fun onCancelInBsClick() {
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        isDeleteBsActive = false
                    }
                }
            }

            override fun onRemoveInBsClick() {
                vm.deletePerson()
                scope.launch { sheetState.hide() }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        isDeleteBsActive = false
                        onBack()
                    }
                }
            }

            override fun onEditClick(personsDataTypes: PersonsDataTypes) {
                onEditPersonDataClick(personsDataTypes.id)
            }

        })
}