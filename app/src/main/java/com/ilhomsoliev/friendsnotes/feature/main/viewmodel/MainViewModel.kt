package com.ilhomsoliev.friendsnotes.feature.main.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import kotlinx.coroutines.launch

class MainViewModel(
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {

    val uiState = mutableStateOf<UiState>(UiState.Loading)

    init {
        viewModelScope.launch {
            if (dataStoreManager.getIsFirstTimeInActive()) {
                uiState.value = UiState.Login
            } else {
                uiState.value = UiState.Loaded
            }
        }
    }


}


sealed class UiState {
    data object Loading : UiState()
    data object Login : UiState()
    data object Loaded : UiState()
}

