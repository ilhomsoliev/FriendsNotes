package com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel

import androidx.lifecycle.ViewModel
import com.ilhomsoliev.friendsnotes.shared.model.PersonType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddPersonViewModel : ViewModel() {
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


    fun onStepChange() {

    }

    fun onPersonTypeChange(personType: PersonType) {
        _personType.value = personType
    }


}