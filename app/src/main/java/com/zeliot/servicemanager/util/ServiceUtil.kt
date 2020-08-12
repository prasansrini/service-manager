package com.zeliot.servicemanager.util

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.zeliot.servicemanager.model.ServicePackageInfo
import java.util.*

object ServiceUtil {
    fun startService(
            info: ServicePackageInfo) {
        val serviceIntent = Intent().apply {
            action = info.action
            `package` = info.packageName
        }

        info.context?.startForegroundService(serviceIntent)
    }

    fun startMultipleServices(
            packageInfoList: ArrayList<ServicePackageInfo>) {
        Handler(Looper.getMainLooper()).post {
            for (info in packageInfoList) {
                val serviceIntent = Intent().apply {
                    action = info.action
                    `package` = info.packageName
                }

                info.context?.startForegroundService(serviceIntent)

                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}