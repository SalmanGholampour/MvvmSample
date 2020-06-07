package com.gholampour.salman.lillydoo_sample.data.remote

import com.gholampour.salman.lillydoo_sample.BuildConfig
import com.gholampour.salman.lillydoo_sample.data.repository.PrefRepository
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class UnauthorizedInterceptor @Inject constructor(
    private val pref: PrefRepository
) : Interceptor {
    private lateinit var tokenService: TokenService
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())

        if (originalResponse.code == 300) {
            return try {
                tokenService = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TokenService::class.java)

                val newToken =
                    tokenService.refreshToken(pref.accessToken, pref.refreshToken).execute().body()
                if (newToken != null) {
                    pref.accessToken ="Bearer "+ newToken.accessToken!!
                    pref.refreshToken = newToken.refreshToken!!

                    chain.proceed(
                        originalResponse.request.newBuilder().removeHeader("Authorization")
                            .addHeader(
                                "Authorization",
                                pref.accessToken
                            )
                            .build()
                    )
                } else {
                    originalResponse
                }
            } catch (e: Exception) {
                originalResponse
            }
        }
        return originalResponse
    }
}