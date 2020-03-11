package com.android.calculateworkerhours.ui.addWorker

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.android.calculateworkerhours.R
import com.android.calculateworkerhours.ui.BaseActivity
import com.android.calculateworkerhours.ui.BaseFragment
import com.android.calculateworkerhours.ui.MainActivity
import com.android.calculateworkerhours.ui.workersList.WorkersViewModel
import com.android.model.Worker
import com.android.util.DialogFactory
import com.android.util.DialogFactoryType
import com.android.util.PermissionUtils
import com.android.util.StateEnum
import kotlinx.android.synthetic.main.fragment_add_worker.*
import org.koin.android.ext.android.inject

class AddWorkerFragment : BaseFragment() {

    private val addWorkerViewModel: AddWorkerViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_worker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save.setOnClickListener {
            validationAndSave()
            activity?.let {
                it.onBackPressed()
            }
        }
    }

    private fun validationAndSave() {
        if (textInputEditText.editableText != null) {
            getCurrentViewModel().state.value = StateEnum.LOADING
            getCurrentViewModel().addData(Worker(null, textInputEditText.editableText.toString()))
        }
    }

    private fun newPhoto() {
        (activity as BaseActivity).checkPermission(
            Runnable {
                //    getCurrentViewModel().getPhotoFromCamera()
            },
            Runnable { showDialogNoPermission() },
            PermissionUtils.WRITE_EXTERNAL_STORAGE,
            PermissionUtils.READ_EXTERNAL_STORAGE
        )
    }

    private fun showDialogNoPermission() {
        DialogFactory(DialogFactoryType.ERROR, activity!!).setInfo(
            getString(R.string.AddWorkerFragment_permissionFromCamera),
            activity!!.getText(R.string.Global_close).toString()
        ).show()
    }

    override fun getCurrentViewModel(): AddWorkerViewModel {
        return addWorkerViewModel
    }

    private fun pickPhoto() {
        val dialog = AlertDialog.Builder(context!!)
        dialog.setTitle(R.string.choose_photo_source)
            .setItems(R.array.photo_sources) { dialog, which ->
                when (which) {
                    0 -> {
                        newPhoto()
                    }
                    1 -> {
                        val pickPhoto = Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                        (activity as BaseActivity).startActivityForResult(pickPhoto, 608)
                    }
                    2 -> {
                        dialog.dismiss()
                    }
                }
            }
        dialog.create().show()
    }

}
