package com.mastek.monark.hybrid.PageObjectsMobile;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.mastek.monark.hybrid.BaseSetup.BaseClass;
import com.mastek.monark.hybrid.ExcelHandling.ExcelHandling;
import com.mastek.monark.hybrid.Reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BaseClass{
	
		
	public HomePage() {
		
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchInput']")
	static WebElement txt_SearchBox;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	static WebElement btn_Submit;
	

	public void searchForContent() throws IOException {
		
		try {
			
			txt_SearchBox.sendKeys(ExcelHandling.Get_Data(TC_ID, "SearchText"));
			
			btn_Submit.click();		
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Searched for text successfully");
			
			ExtentTestManager.takeScreenshot(driver, "sample message for snapshot");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


}
