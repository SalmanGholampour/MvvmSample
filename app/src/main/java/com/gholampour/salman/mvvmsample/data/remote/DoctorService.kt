package com.gholampour.salman.mvvmsample.data.remote


import com.gholampour.salman.mvvmsample.data.model.DoctorsResponse
import retrofit2.Call
import retrofit2.http.*

interface DoctorService {

    @GET
    fun loadDoctors(@Url url: String?): Call<DoctorsResponse>

}