package com.ilhomsoliev.friendsnotes.app

import android.app.Application
import com.ilhomsoliev.friendsnotes.feature.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModule
            )
        }
    }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
}