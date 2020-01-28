package com.android.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class Photo(
                 @SerializedName("id")
                 var id: String? = null,
                 @SerializedName("small")
                 var small: String? = null,
                 @SerializedName("medium")
                 var medium: String? = null) :Serializable