package com.zeliot.servicemanager.util

import android.content.ComponentName
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.zeliot.servicemanager.model.ServicePackageInfo

object ServiceUtil {
    fun startService(
            info: ServicePackageInfo) {
        val serviceIntent = Intent()
        serviceIntent.component = ComponentName(info.packageName, info.action)
        info.context?.startForegroundService(serviceIntent)
    }

    fun startMultipleServices(
            packageInfoList: List<ServicePackageInfo>) {
        Handler(Looper.getMainLooper()).post {
            for (info in packageInfoList) {
                val serviceIntent = Intent()
                serviceIntent.component = ComponentName(info.packageName,
                        info.action)
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
