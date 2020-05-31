package com.gholampour.salman.mvvmsample.di.module

import android.app.Application
import android.content.Context
import com.gholampour.salman.mvvmsample.BuildConfig
import com.gholampour.salman.mvvmsample.data.remote.DoctorService
import com.gholampour.salman.mvvmsample.data.repository.DoctorRepository
import com.gholampour.salman.mvvmsample.data.repository.Repository

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDoctorRepository(repository: DoctorRepository): Repository {
        return repository
    }

    @Provides
    @Singleton
    internal fun provideAppApi(retrofit: Retrofit): DoctorService {
        return retrofit.create(DoctorService::class.java)
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)

            .build()
    }

}
