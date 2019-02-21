package com.mastek.monark.hybrid.Core;

import com.mastek.monark.hybrid.ExcelHandling.ExcelUtils;

public class Constants {
	
/*
 * Configurations
*/

public Constants() {

		
	try {
		
			ExcelUtils excel = new ExcelUtils();
			environmentType = excel.getConfigurationsData("Environment Type");
			reportingFormat = excel.getConfigurationsData("Reporting Format");
			executionRecording = excel.getConfigurationsData("Execution Recording");
			sprintDetails = excel.getConfigurationsData("Sprint Details");
			parallelExecution = excel.getConfigurationsData("Parallel Execution");
			threadCount = excel.getConfigurationsData("Thread Count");
			machineIp = excel.getConfigurationsData("Machine IP");
			startGrid = excel.getConfigurationsData("Start Grid");
			
			appUrl = excel.getWebData("App Url");
			
			platformName = excel.getMobileData("Platform Name");
			platformVersion = excel.getMobileData("Platform Version");
			appPackage = excel.getMobileData("App Package");
			appActivity = excel.getMobileData("App Activity");
			deviceName = excel.getMobileData("Device Name");
			udid = excel.getMobileData("UDID");
			noReset = excel.getMobileData("No Reset");
			
		}catch(Exception e) {
			
			System.out.println("Issue in Constants");
			
		}
		
	}

public static String environmentType;
public static String reportingFormat;
public static String executionRecording;
public static String sprintDetails;
public static String parallelExecution;
public static String threadCount;
public static String machineIp;
public static String startGrid;


/*
 * Web
 */
public static String appUrl;

/*
 * Mobile
 */
public static String platformName;
public static String platformVersion;
public static String appPackage;
public static String appActivity;
public static String deviceName;
public static String udid;
public static String noReset;


}
