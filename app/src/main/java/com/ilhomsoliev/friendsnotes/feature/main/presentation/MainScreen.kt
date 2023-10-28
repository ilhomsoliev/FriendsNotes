package com.ilhomsoliev.friendsnotes.feature.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    vm: MainViewModel,
    onAddNewPerson: () -> Unit,
    openPersonDetails: (id: Int) -> Unit,
) {

    val lovely by vm.lovelyPerson.collectAsState()
    val friends by vm.friends.collectAsState()
    val relatives by vm.relatives.collectAsState()
    val isLoading by vm.isLoading.collectAsState()

    MainContent(
        state = MainState(
            lovely = lovely,
            friends = friends,
            relatives = relatives,
            isLoading = isLoading,
        ), callback = object : MainCallback {
            override fun onMenuClick() {

            }

            override fun onSearchClick() {

            }

            override fun onItemClick(id: Int) {
                openPersonDetails(id)
            }

            override fun onAddNewPerson() {
                onAddNewPerson()
            }
        })
}