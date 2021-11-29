package com.misionTIC.retroshop.di

import com.misionTIC.retroshop.data.repositories.CommentRepository
import com.misionTIC.retroshop.data.repositories.ProductRepository
import com.misionTIC.retroshop.data.repositories.StoreRepository
import org.koin.dsl.module

val repoModule = module {
    single { StoreRepository(get()) }
    single { CommentRepository(get())}
    single { ProductRepository(get())}
}