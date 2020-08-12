package com.zeliot.servicemanager.util

import com.zeliot.servicemanager.model.ServicePackageInfo
import java.util.*

object Constants {
    const val CHANNEL_ID = "SERVICE_MANAGER"
    const val SERVICE_MANAGER = 1
    var PACKAGE_LIST: ArrayList<ServicePackageInfo?> =
            object : ArrayList<ServicePackageInfo?>() {
                init {
                    add(ServicePackageInfo("com.zeliot.wifimanager",
                            "com.zeliot.wifimanager.service.WiFiHandlerService"))
                    add(ServicePackageInfo("com.zeliot.driveassist", ""))
                }
            }
}
