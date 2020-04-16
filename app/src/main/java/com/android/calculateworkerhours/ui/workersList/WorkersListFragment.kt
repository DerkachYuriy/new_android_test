package com.android.calculateworkerhours.ui.workersList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.calculateworkerhours.R
import com.android.calculateworkerhours.ui.BaseFragment
import com.android.calculateworkerhours.ui.MainActivity
import com.android.util.StateEnum
import kotlinx.android.synthetic.main.fragment_workers_list.*

/**
 * A simple [Fragment] subclass.
 */
class WorkersListFragment : BaseFragment() {

    private val adapter = WorkersListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).workersListViewModel.apply {
            getCurrentViewModel().state.value = StateEnum.LOADING
            getCurrentViewModel().getData()
                .observe(activity as MainActivity, Observer {
                    adapter.sedData(it)
                })

            workersList.layoutManager =
                LinearLayoutManager(
                    activity as MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

            workersList.adapter = adapter
        }
    }

    override fun getCurrentViewModel(): WorkersViewModel {
        return (activity as MainActivity).workersListViewModel
    }

}


