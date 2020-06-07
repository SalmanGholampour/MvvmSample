package com.gholampour.salman.lillydoo_sample.data.remote


import com.gholampour.salman.lillydoo_sample.data.model.SampleResponse
import com.gholampour.salman.lillydoo_sample.data.model.TokenResponse
import retrofit2.Call
import retrofit2.http.*

interface TokenService {


    @POST("samples/refresh")
    fun refreshToken(
        @Header("Authorization") token: String,
        @Query("refreshToken") refreshToken: String
    ): Call<TokenResponse>

}