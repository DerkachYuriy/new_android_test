package com.android.data_module

import com.android.model.Worker
import io.reactivex.Observable

interface WorkersLoader {
    fun getWorkersList(): Observable<List<Worker>>
    fun addWorker(worker:Worker)
}