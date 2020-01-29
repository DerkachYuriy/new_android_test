package com.android.datamodule

import android.content.Context
import com.android.data_module.WorkersLoader
import com.android.model.Worker
import com.android.model.dao.WorkerDao
import io.reactivex.Observable
import org.koin.core.KoinComponent

class WorkersLoaderImpl(val context: Context, val workerDao: WorkerDao) : WorkersLoader, KoinComponent {
    override fun addWorker(worker:Worker) {
        workerDao.insert(worker)
    }

    override fun getWorkersList() : Observable<List<Worker>> {
        return workerDao.getAll()
    }
}