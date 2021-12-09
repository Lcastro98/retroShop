package com.misionTIC.retroshop.di

import com.misionTIC.retroshop.ui.viewmodels.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StoreViewModel(get()) }
    viewModel { CommentViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { SplashViewModel(get(),get(),get())}
    viewModel { LoginViewModel(get()) }
}