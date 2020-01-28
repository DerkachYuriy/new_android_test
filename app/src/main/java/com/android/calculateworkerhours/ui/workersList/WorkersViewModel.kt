package com.android.calculateworkerhours.ui.workersList

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.calculateworkerhours.core.MyAndroidViewModel
import com.android.data_module.WorkersLoader
import com.android.model.Worker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkersViewModel(context: Application, val dataManager: WorkersLoader) :
    MyAndroidViewModel(context) {

    private val liveData = MutableLiveData<List<Worker>>()

    init {
        bind()
    }

    fun bind() {
        launch(Dispatchers.Main) {
            loadData()
        }
    }

    fun getData() : MutableLiveData<List<Worker>> {
        return liveData
    }

    private fun loadData() {
        liveData.value = dataManager.getWorkersList()
    }
}
