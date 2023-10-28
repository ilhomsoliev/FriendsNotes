package com.ilhomsoliev.friendsnotes.app

import android.app.Application
import com.ilhomsoliev.friendsnotes.app.di.appModule
import com.ilhomsoliev.friendsnotes.app.di.dataStore
import com.ilhomsoliev.friendsnotes.app.di.repositoryModule
import com.ilhomsoliev.friendsnotes.app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NotesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@NotesApplication)
            modules(
                appModule(),
                repositoryModule,
                viewModelModule,
                dataStore(),
            )
        }
    }
}

