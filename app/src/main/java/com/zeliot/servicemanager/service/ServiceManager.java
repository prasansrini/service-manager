package com.zeliot.servicemanager.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.zeliot.servicemanager.R;
import com.zeliot.servicemanager.model.ServicePackageInfo;
import com.zeliot.servicemanager.util.Constants;
import com.zeliot.servicemanager.util.ServiceUtil;

import java.util.List;

public class ServiceManager extends Service {

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		createNotification();

		List<ServicePackageInfo> packageInfoList = Constants.PACKAGE_LIST;

		for (int element = 0; element < packageInfoList.size(); element++) {
			packageInfoList.get(element).setContext(this);
		}

		ServiceUtil.startMultipleServices(packageInfoList);
		return START_NOT_STICKY;
	}

	private void createNotification() {
		NotificationCompat.Builder notificationBuilder =
				new NotificationCompat.Builder(this, Constants.CHANNEL_ID)
						.setContentTitle("Service Manager")
						.setSmallIcon(R.drawable.ic_service_notification)
						.setColor(getResources().getColor(R.color.colorAccent))
						.setContentText("Service Manager running")
						.setTicker("OK");

		Notification notification = notificationBuilder.build();
		/*
		 * We need notification channels only if the android version is equal to or greater than
		 * Oreo
		 */
		NotificationChannel notificationChannel =
				new NotificationChannel(Constants.CHANNEL_ID,
				                        Constants.CHANNEL_ID,
				                        NotificationManager.IMPORTANCE_DEFAULT);
		notificationChannel.setDescription("Handles the Services ");
		NotificationManager notificationManager =
				(NotificationManager) getSystemService(
						Context.NOTIFICATION_SERVICE);
		if (notificationManager != null) {
			notificationManager.createNotificationChannel(notificationChannel);
		}

		startForeground(Constants.SERVICE_MANAGER, notification);
	}
}
