package com.gholampour.salman.mvvmsample.di.builder


import com.gholampour.salman.mvvmsample.ui.main_list.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindActivity(): MainActivity



}