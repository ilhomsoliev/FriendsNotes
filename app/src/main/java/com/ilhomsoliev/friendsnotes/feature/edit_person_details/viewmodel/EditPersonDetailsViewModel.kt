package com.ilhomsoliev.friendsnotes.feature.edit_person_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.repository.PersonRepository
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditPersonDetailsViewModel(
    private val personRepository: PersonRepository
) : ViewModel() {

    private val _person = MutableStateFlow<PersonModel?>(null)
    val person = _person.asStateFlow()

    fun loadPerson(personId: Int) {
        viewModelScope.launch {
            val person = personRepository.getPersonById(personId)
            _person.value = person
        }
    }

}