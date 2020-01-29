package com.android.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "worker")
data class Worker(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int?,
    @SerializedName("title")
    var name: String = "",
    @SerializedName("avatar")
    var img: String = ""
)