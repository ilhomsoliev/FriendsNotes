package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilhomsoliev.friendsnotes.feature.add_person.presentation.AddPersonScreenComposable
import com.ilhomsoliev.friendsnotes.feature.edit_person_details.presentation.EditPersonDetailsComposable
import com.ilhomsoliev.friendsnotes.feature.main.presentation.MainInitContainerComposable
import com.ilhomsoliev.friendsnotes.feature.on_board.OnBoardContainerComposable
import com.ilhomsoliev.friendsnotes.feature.person_details.presentation.PersonDetailsComposable

@Composable
fun Navigation() {

    val navController = rememberNavController()

    val controller = rememberSystemUiController()

    LaunchedEffect(key1 = Unit, block = {
        controller.setSystemBarsColor(Color(0xFFFFFFFF))
        controller.setNavigationBarColor(Color(0xFFFFFFFF))
        controller.setStatusBarColor(Color(0xFFFFFFFF))
    })

    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {

        MainInitContainerComposable(navController)

        OnBoardContainerComposable(navController)

        AddPersonScreenComposable(navController)

        PersonDetailsComposable(navController)

        EditPersonDetailsComposable(navController)

    }
}
