package com.gholampour.salman.lillydoo_sample.extention

import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume


sealed class CallResult<out V> {
    data class Success<V>(val value: V) : CallResult<V>()
    data class Failure(val error: Throwable) : CallResult<Nothing>()
}

suspend fun <R, V> Call<R>.callAwait(map: (R) -> V): CallResult<V> =
    suspendCancellableCoroutine { continuation ->
        try {
            enqueue(object : Callback<R> {
                override fun onFailure(call: Call<R>, t: Throwable) {
                    continuation.resume(CallResult.Failure(t))
                }

                override fun onResponse(call: Call<R>, response: Response<R>) {
                    if (response.isSuccessful) {
                        try {
                            continuation.resume(
                                CallResult.Success(map(response.body()!!))
                            )
                        } catch (throwable: Throwable) {
                            continuation.resume(CallResult.Failure(throwable))
                        }
                    } else {
                        continuation.resume(
                            CallResult.Failure(
                                Throwable(response.errorBody()?.string())
                            )
                        )
                    }
                }
            })
        } catch (throwable: Throwable) {
            continuation.resume(CallResult.Failure(throwable))
        }
        continuation.invokeOnCancellation {
            cancel()
        }
    }

