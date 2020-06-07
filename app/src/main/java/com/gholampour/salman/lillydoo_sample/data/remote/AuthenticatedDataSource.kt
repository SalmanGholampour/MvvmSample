package com.gholampour.salman.lillydoo_sample.data.remote

import android.content.SharedPreferences
import com.gholampour.salman.lillydoo_sample.data.repository.PrefRepository
import com.gholampour.salman.lillydoo_sample.extention.callAwait
import javax.inject.Inject

class AuthenticatedDataSource @Inject constructor(
    private val authenticatedService: AuthenticatedService,
    private val pref: PrefRepository
) {
    suspend fun getSampleData() =
        authenticatedService.getSampleData1(pref.accessToken).callAwait { it }

}