package com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.data.repository.PersonRepository
import com.ilhomsoliev.friendsnotes.shared.model.PersonType
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

const val maxSteps = 6

class AddPersonViewModel(
    private val personRepository: PersonRepository,
    private val dataStoreManager: DataStoreManager,
) : ViewModel() {
    private val _currentStep = MutableStateFlow(1)
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

    fun onPersonTypeChange(personType: PersonType) {
        _personType.value = personType
    }

    fun onNextScreen() {
        // TODO do extra check before going to next screen
        viewModelScope.launch {
            if (_currentStep.value == maxSteps) {
                // add person into database
                val personName = _personName.value
                val dateOfBirth = _dateOfBirth.value
                val personType = _personType.value
                val favoriteFood = _favoriteFood.value
                val dislikedThings = _dislikedThings.value
                val notes = _notes.value

                if (!(personName.isNotEmpty() &&
                            dateOfBirth != null &&
                            personType != null
                            )
                ) return@launch // Show snackbar

                val personModel = PersonModel(
                    id = null,
                    name = personName,
                    dateOfBirth = dateOfBirth ?: 0L,
                    favoriteFood = favoriteFood,
                    dislikedThings = dislikedThings,
                    notes = notes,
                    type = personType ?: PersonType.LOVELY
                )
                personRepository.addPerson(personModel)
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

    fun onPersonFoodChange(value: String) {
        _favoriteFood.value = value
    }

    fun onPersonDislikedChange(value: String) {
        _dislikedThings.value = value
    }

    fun onPersonNotesChange(value: String) {
        _notes.value = value
    }
}