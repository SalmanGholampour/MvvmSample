package com.gholampour.salman.mvvmsample.data.repository

import com.gholampour.salman.mvvmsample.data.model.DoctorsResponse
import com.gholampour.salman.mvvmsample.extention.CallResult


interface Repository {

    suspend fun loadDoctors(url:String?): CallResult<DoctorsResponse>

}