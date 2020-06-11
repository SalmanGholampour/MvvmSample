package com.gholampour.salman.lillydoo_sample.data.remote


import com.gholampour.salman.lillydoo_sample.data.model.SampleResponse
import com.gholampour.salman.lillydoo_sample.data.model.TokenResponse
import retrofit2.Call
import retrofit2.http.*

interface AuthenticatedService {

    @GET("samples/data1")
    fun getSampleData1(@Header("Authorization") token: String): Call<SampleResponse>

    @POST("samples/data2")
    fun setSampleData2(@Header("Authorization") token: String): Call<SampleResponse>



}