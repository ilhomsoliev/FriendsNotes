package com.ilhomsoliev.friendsnotes.feature.main.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.UiState
import org.koin.androidx.compose.koinViewModel


fun NavGraphBuilder.MainInitContainerComposable(navController: NavController) {
    composable(route = Screens.MainScreen.route) {
        MainInitContainer(
            vm = koinViewModel(),
            openLogin = {
                navController.navigate(Screens.OnBoardingScreen.route) {
                    popUpTo(Screens.MainScreen.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            openAddPerson = {
                navController.navigate(Screens.AddPersonScreen.route)
            }
        )
    }
}

@Composable
fun MainInitContainer(
    vm: MainViewModel,
    openLogin: () -> Unit,
    openAddPerson: () -> Unit,
) {

    val uiState by vm.uiState

    when (uiState) {
        is UiState.Loading -> {
            LoadingScreen(Modifier)
        }

        is UiState.Loaded -> {
            MainScreen(
                vm = vm,
                onAddNewPerson = {
                    openAddPerson()
                }
            )
        }

        is UiState.Login -> {
            openLogin()
        }
    }
}

@Composable
private fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}