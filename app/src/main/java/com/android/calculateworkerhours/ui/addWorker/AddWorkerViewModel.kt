package com.android.calculateworkerhours.ui.addWorker

import android.app.Application
import com.android.calculateworkerhours.core.MyAndroidViewModel
import com.android.data_module.WorkersLoader
import com.android.model.Worker
import com.android.util.StateEnum
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class AddWorkerViewModel (var context: Application, private val dataManager: WorkersLoader) :
    MyAndroidViewModel(context) {


    fun addData(worker: Worker) {
        dataManager.addWorker(worker).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                state.value = StateEnum.LOADING
            }
            .addTo(disposables)
    }

}