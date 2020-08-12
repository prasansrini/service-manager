package com.zeliot.servicemanager.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.zeliot.servicemanager.R
import com.zeliot.servicemanager.util.Constants
import com.zeliot.servicemanager.util.ServiceUtil

class ServiceManager : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        createNotification()
        val packageInfoList =
                Constants.PACKAGE_LIST
        for (element in packageInfoList.indices) {
            packageInfoList[element].context = this
        }

        ServiceUtil.startMultipleServices(packageInfoList)
        return START_NOT_STICKY
    }

    private fun createNotification() {
        val notificationBuilder = NotificationCompat.Builder(this,
                Constants.CHANNEL_ID)
                .setContentTitle("Service Manager")
                .setSmallIcon(R.drawable.ic_service_notification)
                .setColor(resources.getColor(R.color.colorAccent))
                .setContentText("Service Manager running")
                .setTicker("OK")
        val notification = notificationBuilder.build()
        val notificationChannel =
                NotificationChannel(Constants.CHANNEL_ID,
                        Constants.CHANNEL_ID,
                        NotificationManager.IMPORTANCE_DEFAULT)
        notificationChannel.description = "Handles the Services "
        val notificationManager = getSystemService(
                Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
        startForeground(Constants.SERVICE_MANAGER, notification)
    }
}
