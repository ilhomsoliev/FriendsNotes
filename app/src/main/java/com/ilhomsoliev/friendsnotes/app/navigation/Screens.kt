package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.navigation.NavController


sealed class Screens(val route: String) {
    object OnBoardingScreen : Screens("OnBoardingScreen")
    object MainScreen : Screens("MainScreen")
    object AddTransactionScreen : Screens("AddTransactionScreen")
    object AccountScreen : Screens("AccountScreen")
    object AddAccountScreen : Screens("AddAccountScreen")
    object GoalsScreen : Screens("GoalsScreen")
    object AddGoalScreen : Screens("AddGoalScreen")
    object PurchaseScreen: Screens("PurchaseScreen")

}

fun navigateBottom(point:Int) =
    when(point){
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