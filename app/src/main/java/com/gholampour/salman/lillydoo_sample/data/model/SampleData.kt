package com.gholampour.salman.lillydoo_sample.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlin.math.roundToInt

data class SampleData(

    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?


)

