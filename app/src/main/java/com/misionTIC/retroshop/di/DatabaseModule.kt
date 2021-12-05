package com.misionTIC.retroshop.di

import com.misionTIC.retroshop.data.database.AppDataBase
import org.koin.dsl.module

val databaseModule= module {
    single { AppDataBase.getInstance(get()) }
    single {get<AppDataBase>().productDao()}
    single {get<AppDataBase>().commentDao()}

    single {get<AppDataBase>().storeDao()}

}