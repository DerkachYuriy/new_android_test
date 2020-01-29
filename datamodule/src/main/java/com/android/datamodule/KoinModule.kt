package com.android.datamodule

import androidx.room.Room
import com.android.data_module.AppDatabase
import com.android.data_module.WorkersLoader
import org.koin.dsl.module

val dataModule = module {
    //ROOM
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "database").build() }

    single { get<AppDatabase>().workerDao() }

    //ViewModels
    single { WorkersLoaderImpl(get(), get()) as WorkersLoader }


}