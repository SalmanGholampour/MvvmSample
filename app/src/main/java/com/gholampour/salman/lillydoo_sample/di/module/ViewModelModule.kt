package com.gholampour.salman.lillydoo_sample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gholampour.salman.lillydoo_sample.ui.main_list.MainViewModel
import com.gholampour.salman.lillydoo_sample.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindWeathersListViewModel(
        mainViewModel: MainViewModel
    ): ViewModel
}