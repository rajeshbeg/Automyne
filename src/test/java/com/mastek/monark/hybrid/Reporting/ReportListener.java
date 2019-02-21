package com.mastek.monark.hybrid.Reporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.mastek.monark.hybrid.BaseSetup.BaseClass;
import com.mastek.monark.hybrid.ExcelHandling.ExcelHandling;
import com.relevantcodes.extentreports.LogStatus;

public class ReportListener extends BaseClass implements ITestListener{

	
	private static String getTestMethodName(ITestResult iTestResult) {
		
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
    @SuppressWarnings("static-access")
	public void onStart(ITestContext iTestContext) {
    	
//        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
        
        
    }
 
    //After ending all tests, below method runs.
    public void onFinish(ITestContext iTestContext) {
    	
//        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    
    public void onTestStart(ITestResult iTestResult) {
    	
        System.out.println("Method " +  getTestMethodName(iTestResult) + " is executing....");
        //Start operation for extentreports.
        
        String str = iTestResult.getTestClass().getName();
        
        String[] s = str.split("hybrid.");
		
		int cut = s[s.length-1].toString().indexOf(".");
        
        ExtentTestManager.startTest(s[s.length-1].toString().substring(cut+1, s[s.length-1].length()).toString() + " - " + iTestResult.getTestContext().getName() + " - " + ExcelHandling.Get_Data(TC_ID, "Description"),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
    	
        System.out.println("Method " +  getTestMethodName(iTestResult) + " succeeded...");
        //Extentreports log operation for passed tests.
//        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }
 
    public void onTestFailure(ITestResult iTestResult) {
    	
        System.out.println("Method " +  getTestMethodName(iTestResult) + " failed!");
 
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseClass) testClass).getDriver();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
 
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
        ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
    	
        System.out.println("Method "+  getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
    
	
}
