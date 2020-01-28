package com.android.calculateworkerhours.data.model

import com.google.gson.annotations.SerializedName

open class User(
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("avatar")
    var img: String = ""
)