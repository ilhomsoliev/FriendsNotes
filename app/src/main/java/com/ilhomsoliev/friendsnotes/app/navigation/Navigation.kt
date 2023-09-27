package com.ilhomsoliev.friendsnotes.app.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.data.model.NoteEntity
import com.ilhomsoliev.friendsnotes.feature.main.presentation.MainScreen
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.mp.KoinPlatformTools

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
fun Navigation() {

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    val bottomSheetNavigator = remember{
        BottomSheetNavigator(sheetState)
    }

    val navController = rememberNavController(bottomSheetNavigator)

    val dataStore by lazy { KoinPlatformTools.defaultContext().get().get<DataStoreManager>()  }

    ModalBottomSheetLayout(bottomSheetNavigator) {
        NavHost(navController = navController, startDestination = Screens.MainScreen.route) {

            composable(route = Screens.MainScreen.route){
                val viewModel = koinViewModel<MainViewModel>()
                MainScreen(viewModel, navController)
            }
/*
            composable(route = Screens.OnBoardingScreen.route){
                val viewModel = koinViewModel<OnBoardingViewModel>()
                OnBoardingScreen(viewModel, navController)
            }

            composable(route = Screens.AccountScreen.route){
                val viewModel = koinViewModel<AccountsViewModel>()
                AccountsScreen(vm = viewModel, navController = navController)
            }

            composable(route = Screens.GoalsScreen.route) {
                val viewModel = koinViewModel<GoalsViewModel>()
                GoalsScreen(vm = viewModel, navController = navController)
            }*/

            //composable(route = Screens.Add)
           /* bottomSheet(route = Screens.SelectCountry) {
                val viewModel = koinViewModel<CountryBsViewModel>()

                CountryBs(viewModel, navController)
            }
            composable(Screens.Code) {
                val viewModel = koinViewModel<CodeViewModel>()
                CodeScreen(vm = viewModel, navController)
            }
            composable(Screens.AuthProfile) {
                val viewModel = koinViewModel<AuthProfileViewModel>()
                AuthProfileScreen(vm = viewModel, navController)
            }
            composable(Screens.ChatList){
                val viewModel = koinViewModel<ChatListViewModel>()
                ChatListScreen(vm = viewModel, navController)
            }
            composable(Screens.Chat){
                val viewModel = koinViewModel<ChatViewModel>()
                ChatScreen(vm = viewModel, navController)
            }
            composable(Screens.Profile){
                val viewModel = koinViewModel<ProfileViewModel>()
                ProfileScreen(vm = viewModel, navController = navController)
            }
            composable(Screens.EditProfile){
                val viewModel = koinViewModel<EditProfileViewModel>()
                EditProfileScreen(vm = viewModel, navController = navController)
            }*/
        }
    }
}