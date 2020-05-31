package com.gholampour.salman.mvvmsample.ui.main_list.adapter

import androidx.databinding.ObservableField
import com.gholampour.salman.mvvmsample.data.model.DoctorData

class ItemDoctorViewModel(private val doctorData: DoctorData, private val listener: ItemViewListener) {
    var photoId: ObservableField<String> = ObservableField()
    var name: ObservableField<String> = ObservableField()
    var rating: ObservableField<Double> = ObservableField()

    init {
        photoId.set(doctorData.photoId)
        name.set(doctorData.name)
        rating.set(doctorData.rating)
    }

    fun onItemClick() {
        listener.onClick(doctorData)
    }

    interface ItemViewListener {
        fun onClick(doctorData: DoctorData)
    }
}