package com.xhs.algorithm

import android.media.MediaDrm
import android.os.Build
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import java.util.*

object UniqueDeviceID {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Nullable
    fun getUniqueID(): String? {
        val wideVineUuid = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
        return try {
            val wvDrm = MediaDrm(wideVineUuid)
            val wideVineId =
                wvDrm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)
            wideVineId.contentToString()
        } catch (e: Exception) { // Inspect exception
            println("测试${e.message}")
            null
        }
    }
}