package com.gholampour.salman.mvvmsample.ui.main_list.adapter

import com.gholampour.salman.mvvmsample.data.model.DoctorData


interface AdapterCallback {
    fun onItemClick(doctorData: DoctorData)
}