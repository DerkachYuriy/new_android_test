package com.android.calculateworkerhours.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User(
    @PrimaryKey
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("avatar")
    var img: String = ""
) : RealmObject()