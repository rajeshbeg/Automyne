package com.mastek.monark.hybrid.TestsMobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {

	public static void main(String[] args) {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", "OPPO");
		cap.setCapability("udid", "8LLVRCY5TCOBRKUG");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
		cap.setCapability("noReset", true);
		
		try {
			
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElement(By.id("in.amazon.mShop.android.shopping:id/web_home_shop_by_department_label")).click();
			
			driver.findElement(By.id("sbdCategory6")).click();
			
			driver.findElement(By.xpath("//android.view.View[@text='Mobiles ']")).click();
			
			
		}catch(MalformedURLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
	}
	

}
