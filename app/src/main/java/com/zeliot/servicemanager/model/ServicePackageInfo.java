package com.zeliot.servicemanager.model;

import android.content.Context;

public class ServicePackageInfo {
	private Context mContext;
	private String mPackageName;
	private String mAction;

	public Context getContext() {
		return mContext;
	}

	public void setContext(Context mContext) {
		this.mContext = mContext;
	}

	public String getPackageName() {
		return mPackageName;
	}

	public void setPackageName(String mPackageName) {
		this.mPackageName = mPackageName;
	}

	public String getAction() {
		return mAction;
	}

	public void setAction(String mAction) {
		this.mAction = mAction;
	}
}
