package com.gholampour.salman.lillydoo_sample.data.model

import com.google.gson.annotations.SerializedName

data class SampleResponse(

    @SerializedName("data")
    var data: MutableList<SampleData>
)