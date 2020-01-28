package com.android.datamodule

import android.content.Context
import com.android.data_module.WorkersLoader
import com.android.model.Worker
import com.android.request.WorkersRequest
import com.google.gson.Gson
import org.koin.core.KoinComponent

class WorkersLoaderImpl(val context: Context) : WorkersLoader, KoinComponent {

    override fun getWorkersList() : List<Worker> {
        var json = ""
        val dataPath = "data.json"
        context.assets.open(dataPath).bufferedReader().use {
            json = it.readText()
        }
        return Gson().fromJson(json, WorkersRequest::class.java).list
    }
}