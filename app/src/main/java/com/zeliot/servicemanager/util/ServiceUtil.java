package com.zeliot.servicemanager.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class ServiceUtil {
	private ServiceUtil() {
	}

	public static void startService(
			Context context, String packageName, String action) {
		Intent serviceIntent = new Intent();
		serviceIntent.setComponent(new ComponentName(packageName, action));
		context.startForegroundService(serviceIntent);
		//		new Handler(Looper.getMainLooper()).postDelayed(
		//				() -> , 1000);
	}
}
