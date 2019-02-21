package com.mastek.monark.hybrid.Reporting;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {
	
	@SuppressWarnings("rawtypes")
	static Map extentTestMap = new HashMap();
    static ExtentReports extent = ExtentManager.getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
        extent.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
 
    @SuppressWarnings("unchecked")
	public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    public static void takeScreenshot(ThreadLocal<RemoteWebDriver> driver, String stepMessage) throws IOException {
		
    	
       
    	String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver.get()).
                getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
    	
//    	ExtentTestManager.getTest().log(LogStatus.PASS, stepMessage);
        ExtentTestManager.getTest().log(LogStatus.INFO, stepMessage + ": "+ ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

//    	System.out.println(driver.get().getTitle());
    	
    }
    

}
