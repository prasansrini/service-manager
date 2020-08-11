package com.zeliot.servicemanager.model;

import android.content.Context;

public class ServicePackageInfo {
	private Context mContext;
	private String mPackageName;
	private String mAction;

	public ServicePackageInfo(
			String packageName, String action) {
		mPackageName = packageName;
		mAction = action;
	}

	public void setContext(Context context) {
		mContext = context;
	}

	public Context getContext() {
		return mContext;
	}

	public String getPackageName() {
		return mPackageName;
	}

	public String getAction() {
		return mAction;
	}

}
