package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.navigation.NavController


sealed class Screens(val route: String) {
    data object OnBoardingScreen : Screens("OnBoardingScreen")
    data object MainScreen : Screens("MainScreen")
    data object AddTransactionScreen : Screens("AddTransactionScreen")
    data object AccountScreen : Screens("AccountScreen")
    data object AddPersonScreen : Screens("AddPersonScreen")
    data object GoalsScreen : Screens("GoalsScreen")
    data object AddGoalScreen : Screens("AddGoalScreen")
    data object PurchaseScreen : Screens("PurchaseScreen")

}

fun navigateBottom(point: Int) =
    when (point) {
        0 -> Screens.MainScreen.route
        1 -> Screens.AccountScreen.route
        2 -> Screens.GoalsScreen.route
        else -> Screens.GoalsScreen.route
    }

fun NavController.clearStackNavigation(route: String) {
    this.navigate(route) {
        popUpTo(0)
    }
}