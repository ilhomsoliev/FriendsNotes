package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.navigation.NavBackStackEntry


sealed class Screens(val route: String) {
    data object OnBoardingScreen : Screens("OnBoardingScreen")
    data object MainScreen : Screens("MainScreen")
    data object PersonDetailsScreen : Screens("PersonDetailsScreen/{personId}") {
        fun buildRoute(personId: Int): String = "PersonDetailsScreen/${personId}"
        fun getPersonId(entry: NavBackStackEntry): Int =
            entry.arguments!!.getString("personId")?.toInt()
                ?: throw IllegalArgumentException("personId argument missing.")
    }
    data object EditPersonDetailsScreen : Screens("EditPersonDetailsScreen/{personId}") {
        fun buildRoute(personId: Int): String = "EditPersonDetailsScreen/${personId}"
        fun getPersonId(entry: NavBackStackEntry): Int =
            entry.arguments!!.getString("personId")?.toInt()
                ?: throw IllegalArgumentException("personId argument missing.")
    }

    data object AddTransactionScreen : Screens("AddTransactionScreen")
    data object AccountScreen : Screens("AccountScreen")
    data object AddPersonScreen : Screens("AddPersonScreen")
    data object GoalsScreen : Screens("GoalsScreen")
}