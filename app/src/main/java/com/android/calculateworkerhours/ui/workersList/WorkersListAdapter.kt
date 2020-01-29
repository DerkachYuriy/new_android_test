package com.android.calculateworkerhours.ui.workersList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.calculateworkerhours.R
import com.android.model.Worker
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.workers_list_item.view.*

class WorkersListAdapter : RecyclerView.Adapter<WorkersListAdapter.ExhibitItemViewHolder>() {

    val dataList = ArrayList<Worker>()

    var actionItemClicked: (item: Worker) -> Unit = {}

    fun sedData(list: List<Worker>) {
        this.dataList.clear()
        this.dataList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItem(item: Worker) {
        dataList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitItemViewHolder {
        return ExhibitItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.workers_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ExhibitItemViewHolder, position: Int) {
        holder.bind(dataList[position], actionItemClicked)
    }

    class ExhibitItemViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Worker, actionItemClicked: (item: Worker) -> Unit) {

            containerView.name.text = item.name

            containerView.rootView.setOnClickListener {
                actionItemClicked.invoke(item)
            }
        }
    }
}