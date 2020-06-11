package com.gholampour.salman.mvvmsample.data.remote

import com.gholampour.salman.mvvmsample.extention.callAwait
import javax.inject.Inject

class DoctorsListDataSource @Inject constructor(private val doctorService: DoctorService) {
    suspend fun loadDoctors(url: String?) =
        doctorService.loadDoctors(url).callAwait { it }

}