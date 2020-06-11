package com.gholampour.salman.lillydoo_sample.data.repository

import com.gholampour.salman.lillydoo_sample.data.model.SampleResponse
import com.gholampour.salman.lillydoo_sample.extention.CallResult


interface Repository {

    suspend fun loadAuthData(): CallResult<SampleResponse>

    suspend fun loadUnAuthData(): CallResult<SampleResponse>

}