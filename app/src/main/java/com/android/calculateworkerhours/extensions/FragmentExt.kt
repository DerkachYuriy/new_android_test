package com.android.calculateworkerhours.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.calculateworkerhours.R
import com.android.calculateworkerhours.ui.BaseActivity
import com.android.util.DialogFactory
import com.android.util.DialogFactoryType

fun Fragment.showProgressDialog() {
    if (activity != null && activity is BaseActivity)
        (activity as BaseActivity).getProgressBar().visibility = View.VISIBLE
}

fun Fragment.dismissDialogs() {
    if (activity != null && activity is BaseActivity)
        (activity as BaseActivity).getProgressBar().visibility = View.GONE
}

fun Fragment.showError(errorText: String) {
    if (activity != null && activity is AppCompatActivity) {
        DialogFactory(DialogFactoryType.ERROR, activity as AppCompatActivity).setInfo(
            errorText,
            (activity as AppCompatActivity).getText(R.string.Global_close).toString()
        ).show()
    }
}
