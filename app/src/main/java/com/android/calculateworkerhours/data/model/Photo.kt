package com.android.calculateworkerhours.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Photo(@PrimaryKey
                 @SerializedName("id")
                 var id: String? = null,
                 @SerializedName("small")
                 var small: String? = null,
                 @SerializedName("medium")
                 var medium: String? = null) : RealmObject(), Serializable