package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.AddPersonScreenComposable
import com.ilhomsoliev.friendsnotes.feature.main.presentation.MainInitContainerComposable
import com.ilhomsoliev.friendsnotes.feature.on_board.OnBoardContainerComposable

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.AddPersonScreen.route/*Screens.MainScreen.route*/
    ) {

        MainInitContainerComposable(navController)

        OnBoardContainerComposable(navController)

        AddPersonScreenComposable(navController)

    }
}
