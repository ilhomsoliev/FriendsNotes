package com.ilhomsoliev.friendsnotes.feature.main.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.data.repository.PersonRepository
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import com.ilhomsoliev.friendsnotes.shared.model.person.map
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel(
    private val dataStoreManager: DataStoreManager,
    private val personRepository: PersonRepository,
) : ViewModel() {

    private val _lovelyPerson = MutableStateFlow<PersonModel?>(null)
    val lovelyPerson = _lovelyPerson.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _friends = MutableStateFlow<List<PersonModel>>(emptyList())
    val friends = _friends.asStateFlow()

    private val _relatives = MutableStateFlow<List<PersonModel>>(emptyList())
    val relatives = _relatives.asStateFlow()

    val uiState = mutableStateOf<UiState>(UiState.Loading)

    init {
        viewModelScope.launch {
            if (dataStoreManager.getIsFirstTimeInActive()) {
                uiState.value = UiState.Login
            } else {
                uiState.value = UiState.Loaded
            }
        }

        personRepository.getLovely().onEach {
            if (it.isNotEmpty()) {
                _lovelyPerson.value = it[0].map()
            }
        }.launchIn(viewModelScope)

        personRepository.getFriends().onEach {
            _friends.value = it.map { it.map() }
        }.launchIn(viewModelScope)

        personRepository.getRelatives().onEach {
            _relatives.value = it.map { it.map() }
        }.launchIn(viewModelScope)

    }

}


sealed class UiState {
    data object Loading : UiState()
    data object Login : UiState()
    data object Loaded : UiState()
}

