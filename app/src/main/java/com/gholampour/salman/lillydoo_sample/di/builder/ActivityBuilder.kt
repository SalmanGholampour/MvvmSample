package com.gholampour.salman.lillydoo_sample.di.builder


import com.gholampour.salman.lillydoo_sample.ui.main_list.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindActivity(): MainActivity



}