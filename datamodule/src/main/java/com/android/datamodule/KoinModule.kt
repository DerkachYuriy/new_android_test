package com.android.datamodule

import com.android.data_module.WorkersLoader
import org.koin.dsl.module

val dataModule = module {
    single { WorkersLoaderImpl(get()) as WorkersLoader }
}