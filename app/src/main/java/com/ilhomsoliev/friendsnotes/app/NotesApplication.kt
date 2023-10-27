package com.ilhomsoliev.friendsnotes.app

import android.app.Application
import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.feature.add_person.viewmodel.AddPersonViewModel
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class NotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NotesApplication)
            modules(
                viewModelModule,
                dataStore(),
            )
        }
    }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { AddPersonViewModel() }
}

fun dataStore() = module {
    single { DataStoreManager(androidContext()) }
}