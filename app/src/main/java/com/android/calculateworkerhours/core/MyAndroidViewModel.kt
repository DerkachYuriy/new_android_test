package com.android.calculateworkerhours.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class MyAndroidViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val disposables = CompositeDisposable()

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
        cancel()
    }
}