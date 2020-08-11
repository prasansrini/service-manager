package com.zeliot.servicemanager.util;

import com.zeliot.servicemanager.model.ServicePackageInfo;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String CHANNEL_ID = "SERVICE_MANAGER";
	public static final int SERVICE_MANAGER = 1;
	public static List<ServicePackageInfo> PACKAGE_LIST =
			new ArrayList<ServicePackageInfo>() {{
				add(new ServicePackageInfo("com.zeliot.wifimanager",
				                           "com.zeliot.wifimanager.service.WiFiHandlerService"));
				add(new ServicePackageInfo("com.zeliot.driveassist", ""));
			}};
}
