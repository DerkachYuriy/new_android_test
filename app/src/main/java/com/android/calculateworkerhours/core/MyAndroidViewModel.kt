package com.android.calculateworkerhours.core

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.util.StateEnum
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class MyAndroidViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val disposables = CompositeDisposable()
    val errorMessage = ObservableField<String>("")
    open val state = MutableLiveData<StateEnum>(StateEnum.NONE)

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        cancel()
    }
}