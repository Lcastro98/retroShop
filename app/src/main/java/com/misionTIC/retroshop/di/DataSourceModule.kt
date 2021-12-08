package com.misionTIC.retroshop.di

import com.google.firebase.auth.FirebaseAuth
import com.misionTIC.retroshop.data.mockups.CommentMock
import com.misionTIC.retroshop.data.mockups.ProductMock
import com.misionTIC.retroshop.data.mockups.StoreInfoMock
import org.koin.dsl.module

val dataSourceModule = module {
    single { CommentMock() }
    single { ProductMock() }
    single { StoreInfoMock() }
    single { FirebaseAuth.getInstance() }
}