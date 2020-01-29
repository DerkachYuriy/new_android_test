package com.android.calculateworkerhours.ui.workersList

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.calculateworkerhours.core.MyAndroidViewModel
import com.android.data_module.WorkersLoader
import com.android.model.Worker
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkersViewModel(var context: Application, val dataManager: WorkersLoader) :
    MyAndroidViewModel(context) {

    private val workersList: MutableLiveData<List<Worker>> = MutableLiveData()

    init {
        bind()
    }

    private fun bind() {
        launch(Dispatchers.Main) {
            loadData()
        }
    }

    fun addData(worker: Worker) {
        dataManager.addWorker(worker).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            .addTo(disposables)
    }

    fun getData(): LiveData<List<Worker>> {
        return workersList
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        dataManager.getWorkersList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { workers ->
                workersList.postValue(workers)
            }
    }
}
