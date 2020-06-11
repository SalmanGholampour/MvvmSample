package com.gholampour.salman.mvvmsample.data.repository

import com.gholampour.salman.mvvmsample.data.remote.DoctorsListDataSource
import javax.inject.Inject

class DoctorRepository @Inject constructor(private val doctorsListDataSource: DoctorsListDataSource) :
    Repository {

    override suspend fun loadDoctors(url: String?) =
        doctorsListDataSource.loadDoctors(url)


}