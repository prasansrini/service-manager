package com.zeliot.servicemanager.model

import android.content.Context

class ServicePackageInfo(
        val packageName: String, val action: String) {
    var context: Context? = null

}