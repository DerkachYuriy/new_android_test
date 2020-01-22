package com.android.calculateworkerhours

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.android.calculateworkerhours.ui.activity.BaseActivity
import com.android.util.DialogFactory
import com.android.util.DialogFactoryType
import com.android.util.PermissionUtils
import kotlinx.android.synthetic.main.fragment_add_worker.*

class AddWorkerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_worker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editPhoto.setOnClickListener {
            pickPhoto()
        }
    }
   private fun newPhoto() {
        (activity as BaseActivity).checkPermission(
            Runnable {
            //    getCurrentViewModel().getPhotoFromCamera()
            },
            Runnable { showDialogNoPermission() }, PermissionUtils.WRITE_EXTERNAL_STORAGE, PermissionUtils.READ_EXTERNAL_STORAGE
        )
   }

    private fun showDialogNoPermission() {
        DialogFactory(DialogFactoryType.ERROR, activity!!).setInfo(
            getString(R.string.AddWorkerFragment_permissionFromCamera),
            activity!!.getText(R.string.Global_close).toString()
        ).show()
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
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
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
