package com.android.calculateworkerhours.di

import com.android.calculateworkerhours.ui.workersList.WorkersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { WorkersViewModel(get(), get()) }
}