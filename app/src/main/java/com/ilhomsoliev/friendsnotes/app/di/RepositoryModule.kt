package com.ilhomsoliev.friendsnotes.app.di

import com.ilhomsoliev.friendsnotes.data.repository.PersonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { PersonRepository(get()) }
}