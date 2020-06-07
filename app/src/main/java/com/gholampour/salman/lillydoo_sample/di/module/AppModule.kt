package com.gholampour.salman.lillydoo_sample.di.module

import android.app.Application
import android.content.Context
import com.gholampour.salman.lillydoo_sample.BuildConfig
import com.gholampour.salman.lillydoo_sample.data.remote.AuthenticatedService
import com.gholampour.salman.lillydoo_sample.data.remote.UnAuthenticatedService
import com.gholampour.salman.lillydoo_sample.data.remote.UnauthorizedInterceptor
import com.gholampour.salman.lillydoo_sample.data.repository.PrefRepository
import com.gholampour.salman.lillydoo_sample.data.repository.RepositoryImpl
import com.gholampour.salman.lillydoo_sample.data.repository.Repository

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
    internal fun provideRepository(repositoryImpl: RepositoryImpl): Repository {
        return repositoryImpl
    }

    @Provides
    @Singleton
    internal fun provideAuthApi(retrofit: Retrofit): AuthenticatedService {
        return retrofit.create(AuthenticatedService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideUnAuthApi(retrofit: Retrofit): UnAuthenticatedService {
        return retrofit.create(UnAuthenticatedService::class.java)
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
    internal fun provideOkHttpClient(unauthorizedInterceptor:UnauthorizedInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(unauthorizedInterceptor)
            .build()
    }
    @Provides
    @Singleton
    internal fun provideUnauthorizedInterceptor(pref: PrefRepository): UnauthorizedInterceptor {
        return UnauthorizedInterceptor(pref)
    }
}
