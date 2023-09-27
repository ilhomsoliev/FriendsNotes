package com.ilhomsoliev.friendsnotes.feature.main.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel

@Composable
fun MainScreen(vm: MainViewModel, navController: NavController) {
    MainContent(state = MainState(false), callback = object : MainCallback {
        override fun onMenuClick() {

        }

        override fun onSearchClick() {

        }

        override fun onItemClick() {

        }
    })
}