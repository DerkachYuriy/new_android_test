package com.android.calculateworkerhours.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.android.calculateworkerhours.core.MyAndroidViewModel
import com.android.calculateworkerhours.extensions.dismissDialogs
import com.android.calculateworkerhours.extensions.showError
import com.android.calculateworkerhours.extensions.showProgressDialog
import com.android.util.StateEnum


abstract class BaseFragment : Fragment() {

    abstract fun getCurrentViewModel(): MyAndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                activity?.onBackPressed()
        }
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        getCurrentViewModel().state.observe(this@BaseFragment, Observer {
            when (it) {
                StateEnum.LOADING -> {
                    showProgressDialog()
                }
                StateEnum.COMPLETE -> {
                    dismissDialogs()
                }
                StateEnum.ERROR -> {
                    dismissDialogs()
                    getCurrentViewModel().errorMessage.get()?.let { errorText ->

                        showError(errorText)
                    }
                }
            }
        })

    }

}