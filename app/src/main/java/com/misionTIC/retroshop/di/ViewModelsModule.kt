package com.misionTIC.retroshop.di

import com.misionTIC.retroshop.ui.viewmodels.CommentViewModel
import com.misionTIC.retroshop.ui.viewmodels.ProductViewModel
import com.misionTIC.retroshop.ui.viewmodels.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { StoreViewModel(get()) }
    viewModel { CommentViewModel(get()) }
    viewModel { ProductViewModel(get()) }
}