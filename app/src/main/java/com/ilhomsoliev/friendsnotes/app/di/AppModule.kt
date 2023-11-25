package com.ilhomsoliev.friendsnotes.app.di

import com.ilhomsoliev.friendsnotes.data.DataStoreManager
import com.ilhomsoliev.friendsnotes.data.dao.PersonDao
import com.ilhomsoliev.friendsnotes.data.db.ApplicationDatabase
import com.ilhomsoliev.friendsnotes.data.db.getDatabaseInstance
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun appModule() = module {
    single { getDatabaseInstance(androidContext()) }
    single<PersonDao> { get<ApplicationDatabase>().personDao() }
}//jnjknkjnjk asd adsfadsf asdf adsf asdf asd f

fun dataStore() = module {
    single { DataStoreManager(androidContext()) }
}
// ads fasdf hbhjbhj sdf asdf

