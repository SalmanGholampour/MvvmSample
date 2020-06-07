package com.gholampour.salman.lillydoo_sample.data.remote

import com.gholampour.salman.lillydoo_sample.extention.callAwait
import javax.inject.Inject

class UnAuthenticatedDataSource @Inject constructor(private val unAuthenticatedService: UnAuthenticatedService) {
    suspend fun getSampleData() =
        unAuthenticatedService.getSampleData1().callAwait { it }

}