package com.ilhomsoliev.friendsnotes.app.di

import com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel.AddPersonViewModel
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel
import com.ilhomsoliev.friendsnotes.feature.person_details.viewmodel.PersonDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { AddPersonViewModel(get(), get()) }
    viewModel { PersonDetailsViewModel(get()) }
}
