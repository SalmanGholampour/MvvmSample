package com.gholampour.salman.lillydoo_sample.ui.main_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.gholampour.salman.lillydoo_sample.R
import com.gholampour.salman.lillydoo_sample.base.BaseActivity
import com.gholampour.salman.lillydoo_sample.databinding.ActivityMainBinding
import com.gholampour.salman.lillydoo_sample.delegates.contentView
import javax.inject.Inject

class MainActivity() : BaseActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val binding by contentView<MainActivity, ActivityMainBinding>(
        R.layout.activity_main
    )
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setAccessToken()
        viewModel.loadData()
    }


}
