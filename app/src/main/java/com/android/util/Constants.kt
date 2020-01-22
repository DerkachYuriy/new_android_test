package com.android.util

import androidx.annotation.IntDef
import androidx.annotation.StringDef


class Constants {

    companion object {

        @IntDef(PERMISSION)
        @Retention(AnnotationRetention.SOURCE)
        annotation class RequestCode
        const val PERMISSION = 999

        @IntDef(MIN)
        @Retention(AnnotationRetention.SOURCE)
        annotation class Limit

        const val MIN = 10
        const val FIRST_PAGE = 0

        annotation class Extras
        const val POSITION = "position"
        const val PHOTOS = "photos"
    }
}