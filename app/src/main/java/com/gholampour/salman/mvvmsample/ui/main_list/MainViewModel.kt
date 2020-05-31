package com.gholampour.salman.mvvmsample.ui.main_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gholampour.salman.mvvmsample.base.BaseViewModel
import com.gholampour.salman.mvvmsample.data.model.DoctorData
import com.gholampour.salman.mvvmsample.data.repository.Repository
import com.gholampour.salman.mvvmsample.extention.CallResult
import com.gholampour.salman.mvvmsample.util.getUrl
import kotlinx.coroutines.*
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : BaseViewModel() {

    private var lastKey: String? = ""
    private val _progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val progressLiveData: LiveData<Boolean> = _progressLiveData

    private val _listViewLiveData: MutableLiveData<List<DoctorData>> = MutableLiveData()
    val listViewLiveData: LiveData<List<DoctorData>> = _listViewLiveData


    private fun setPageLoading(isLoading: Boolean) {
        _progressLiveData.postValue(isLoading)
    }

    fun loadData() {
        launch {
            setPageLoading(true)
            withContext(Dispatchers.IO) {
                val result = repository.loadDoctors(getUrl(lastKey))

                if (result is CallResult.Success) {
                    val listForView = result.value.data
                    _listViewLiveData.postValue(listForView ?: listOf())
                }
            }
            setPageLoading(false)
        }
    }
}