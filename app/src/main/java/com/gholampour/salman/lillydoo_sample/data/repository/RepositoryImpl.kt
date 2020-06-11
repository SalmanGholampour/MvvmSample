package com.gholampour.salman.lillydoo_sample.data.repository

import com.gholampour.salman.lillydoo_sample.data.model.SampleResponse
import com.gholampour.salman.lillydoo_sample.data.remote.AuthenticatedDataSource
import com.gholampour.salman.lillydoo_sample.data.remote.UnAuthenticatedDataSource
import com.gholampour.salman.lillydoo_sample.extention.CallResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val authenticatedDataSource: AuthenticatedDataSource,
    private val unAuthenticatedDataSource: UnAuthenticatedDataSource
) :
    Repository {


    override suspend fun loadAuthData(): CallResult<SampleResponse> {
        return authenticatedDataSource.getSampleData()
    }

    override suspend fun loadUnAuthData(): CallResult<SampleResponse> {
        return unAuthenticatedDataSource.getSampleData()
    }


}