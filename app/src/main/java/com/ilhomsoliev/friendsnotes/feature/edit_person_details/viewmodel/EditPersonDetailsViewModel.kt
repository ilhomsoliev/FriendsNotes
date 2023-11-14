package com.ilhomsoliev.friendsnotes.feature.edit_person_details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilhomsoliev.friendsnotes.data.repository.PersonRepository
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonModel
import com.ilhomsoliev.friendsnotes.shared.model.person.PersonsDataTypes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditPersonDetailsViewModel(
    private val personRepository: PersonRepository
) : ViewModel() {

    private val _person = MutableStateFlow<PersonModel?>(null)
    val person = _person.asStateFlow()

    private val _personsDataType = MutableStateFlow<PersonsDataTypes?>(null)
    val personsDataType = _personsDataType.asStateFlow()

    fun loadPerson(personId: Int, personDataId: String) {
        viewModelScope.launch {
            _personsDataType.value = PersonsDataTypes.getPersonsDataTypeById(personDataId, )
            val person = personRepository.getPersonById(personId)
            _person.value = person
        }
    }


}