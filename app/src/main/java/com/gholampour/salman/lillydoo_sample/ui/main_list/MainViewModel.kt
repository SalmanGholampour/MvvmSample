package com.gholampour.salman.lillydoo_sample.ui.main_list

import com.gholampour.salman.lillydoo_sample.base.BaseViewModel
import com.gholampour.salman.lillydoo_sample.data.repository.PrefRepository
import com.gholampour.salman.lillydoo_sample.data.repository.Repository
import com.gholampour.salman.lillydoo_sample.extention.CallResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val pref: PrefRepository
) : BaseViewModel() {

    fun loadData() {

        launch {
            withContext(Dispatchers.IO) {
                val result = repository.loadAuthData()

                if (result is CallResult.Success) {
                    //Do something
                }
            }
        }
    }

    //    just for having Access Token
    fun setAccessToken() {
        if
                (pref.accessToken.isNullOrEmpty()) {
            pref.accessToken = "Bearer "+"SomeAccessToken"
        }
    }
}