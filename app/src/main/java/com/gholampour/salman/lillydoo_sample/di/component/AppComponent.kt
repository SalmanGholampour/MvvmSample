package com.gholampour.salman.lillydoo_sample.di.component

import android.app.Application
import com.gholampour.salman.lillydoo_sample.MainApplication
import com.gholampour.salman.lillydoo_sample.di.builder.ActivityBuilder
import com.gholampour.salman.lillydoo_sample.di.module.AppModule
import com.gholampour.salman.lillydoo_sample.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class, ViewModelModule::class])

interface AppComponent {
    fun inject(app: MainApplication)



    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}