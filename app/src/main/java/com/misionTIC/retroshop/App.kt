package com.misionTIC.retroshop

import android.app.Application
import com.misionTIC.retroshop.di.dataSourceModule
import com.misionTIC.retroshop.di.repoModule
import com.misionTIC.retroshop.di.viewModelModule
import com.misionTIC.retroshop.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(dataSourceModule, repoModule, viewModelModule,databaseModule)
        }
    }
}