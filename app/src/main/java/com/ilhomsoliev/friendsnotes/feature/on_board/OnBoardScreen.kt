package com.ilhomsoliev.friendsnotes.feature.on_board

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ilhomsoliev.friendsnotes.app.navigation.Screens

fun NavGraphBuilder.OnBoardContainerComposable(navController: NavController) {
    composable(route = Screens.OnBoardingScreen.route) {
        OnBoardScreen {
            navController.navigate(Screens.AddPersonScreen.route)
        }
    }
}

@Composable
fun OnBoardScreen(
    getStarted: () -> Unit
) {

    OnBoardContent(object : OnBoardCallback {
        override fun onStartClick() {
            getStarted()
        }
    })

}