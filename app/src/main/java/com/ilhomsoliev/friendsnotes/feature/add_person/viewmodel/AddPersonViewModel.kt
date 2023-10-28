package com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.shared.model.PersonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AddPersonViewModel(
    val dataStoreManager: DataStoreManager
) : ViewModel() {
    private val _currentStep = MutableStateFlow(3) // TODO change it to 1
    val currentStep = _currentStep.asStateFlow()

    private val _personType = MutableStateFlow<PersonType?>(null)
    val personType = _personType.asStateFlow()

    private val _personName = MutableStateFlow("")
    val personName = _personName.asStateFlow()

    private val _favoriteFood = MutableStateFlow("")
    val favoriteFood = _favoriteFood.asStateFlow()

    private val _dislikedThings = MutableStateFlow("")
    val dislikedThings = _dislikedThings.asStateFlow()

    private val _notes = MutableStateFlow("")
    val notes = _notes.asStateFlow()

    private val _dateOfBirth = MutableStateFlow<Long?>(null)
    val dateOfBirth = _dateOfBirth.asStateFlow()


    fun onStepChange() {

    }

    fun onPersonTypeChange(personType: PersonType) {
        _personType.value = personType
    }

    fun onNextScreen() {
        // TODO do extra check before going to next screen
        viewModelScope.launch {
            if (_currentStep.value == 5) {
                dataStoreManager.changeIsFirstTimeInActive(false)
            }
            _currentStep.value = _currentStep.value + 1
        }
    }

    fun onPrevScreen() {
        if (_currentStep.value != 1) {
            _currentStep.value = _currentStep.value - 1
        }
    }

    fun onPersonNameChange(value: String) {
        _personName.value = value
    }

    fun onDateOfBirthChange(value: Long) {
        _dateOfBirth.value = value
    }
}