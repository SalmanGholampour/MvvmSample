package com.gholampour.salman.lillydoo_sample.data.repository

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject


class PrefRepository @Inject constructor(context: Context) {

    private var mPrefs: SharedPreferences =
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    var accessToken: String
        get() = mPrefs.getString(ACCESS_TOKEN, "")!!
        set(mAccessToken) {
            mPrefs.edit().putString(ACCESS_TOKEN, mAccessToken).apply()
        }

    var refreshToken: String
        get() = mPrefs.getString(ACCESS_TOKEN, "")!!
        set(mRefreshToken) {
            mPrefs.edit().putString(ACCESS_TOKEN, mRefreshToken).apply()
        }


    companion object {

        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"


    }


}

