package com.android.model

import com.google.gson.annotations.SerializedName

open class Worker(
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("avatar")
    var img: String = ""
)