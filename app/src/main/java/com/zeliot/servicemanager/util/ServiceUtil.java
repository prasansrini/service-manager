package com.zeliot.servicemanager.util;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.zeliot.servicemanager.model.ServicePackageInfo;

import java.util.List;

public class ServiceUtil {
	private ServiceUtil() {
	}

	public static void startService(
			ServicePackageInfo info) {
		Intent serviceIntent = new Intent();
		serviceIntent.setComponent(
				new ComponentName(info.getContext(), info.getAction()));
		info.getContext().startForegroundService(serviceIntent);
	}

	public static void startMultipleServices(
			List<ServicePackageInfo> packageInfoList) {
		new Handler(Looper.getMainLooper()).postDelayed(() -> {
			for (ServicePackageInfo info : packageInfoList) {
				Intent serviceIntent = new Intent();
				serviceIntent.setComponent(
						new ComponentName(info.getContext(), info.getAction()));
				info.getContext().startForegroundService(serviceIntent);
			}
		}, 100);
	}
}
