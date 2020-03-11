package com.android.calculateworkerhours.ui

import android.view.MenuItem
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.android.util.CheckPermissionsUtils

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getProgressBar(): ProgressBar

    private var runnableAction: Runnable? = null
    private var cancelAction: Runnable? = null

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home ->
                onBackPressed()
        }
        return false
    }

    fun checkPermission(
        permitAction: Runnable,
        cancelAction: Runnable?,
        vararg permissions: String
    ) {
        this.runnableAction = permitAction
        this.cancelAction = cancelAction
        if (CheckPermissionsUtils.checkPermission(this, permissions))
            permitAction.run()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        CheckPermissionsUtils.handlePermissions(
            requestCode,
            grantResults,
            runnableAction!!,
            cancelAction
        )
    }

}