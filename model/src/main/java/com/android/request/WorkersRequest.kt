package com.android.request

import com.android.model.Worker
import com.google.gson.annotations.SerializedName

class WorkersRequest (@SerializedName("list") val list: List<Worker>)