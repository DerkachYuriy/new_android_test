package com.android.data_module

import androidx.room.Database
import androidx.room.RoomDatabase

import com.android.model.Worker
import com.android.model.dao.WorkerDao

@Database(entities = [Worker::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workerDao(): WorkerDao
}

