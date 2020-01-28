package com.android.data_module

import com.android.model.Worker

interface WorkersLoader {
    fun getWorkersList(): List<Worker>
}