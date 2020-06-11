package com.gholampour.salman.mvvmsample.ui.main_list.adapter

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.gholampour.salman.mvvmsample.data.model.DoctorData

class DoctorDiffCallback(
    private val oldList: List<DoctorData>,
    private val newList: List<DoctorData>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id

    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        val item = oldList[oldPosition]
        val item2 = newList[newPosition]
        return item == item2


    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}