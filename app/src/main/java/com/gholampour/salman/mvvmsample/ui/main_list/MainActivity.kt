package com.gholampour.salman.mvvmsample.ui.main_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.gholampour.salman.mvvmsample.R
import com.gholampour.salman.mvvmsample.base.BaseActivity
import com.gholampour.salman.mvvmsample.data.model.DoctorData
import com.gholampour.salman.mvvmsample.databinding.ActivityMainBinding
import com.gholampour.salman.mvvmsample.delegates.contentView
import com.gholampour.salman.mvvmsample.ui.main_list.adapter.AdapterCallback
import com.gholampour.salman.mvvmsample.ui.main_list.adapter.ItemListAdapter
import javax.inject.Inject

class MainActivity() : BaseActivity(),
    AdapterCallback {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val binding by contentView<MainActivity, ActivityMainBinding>(
        R.layout.activity_main
    )
    private lateinit var listAdapter: ItemListAdapter
    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModels()
        setupViews()
        viewModel.loadData()
    }

    private fun setupViewModels() {


        viewModel.listViewLiveData.observe(this, Observer {
            listAdapter.updateData(it)

        })

    }

    private fun setupViews() {
        listAdapter =
            ItemListAdapter(
                mutableListOf(),
                this
            )
        with(binding.listRecyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            adapter = listAdapter
        }


    }

    override fun onItemClick(doctorData: DoctorData) {
    }

}
