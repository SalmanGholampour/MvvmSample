package com.gholampour.salman.lillydoo_sample.data.remote


import com.gholampour.salman.lillydoo_sample.data.model.SampleResponse
import retrofit2.Call
import retrofit2.http.*

interface UnAuthenticatedService {

    @GET("samples/unaouth/data1")
    fun getSampleData1(): Call<SampleResponse>

    @GET("samples/unaouth/data2")
    fun getSampleData2(): Call<SampleResponse>

    @GET("samples/unaouth/data3")
    fun getSampleData3(): Call<SampleResponse>
}