package com.mastek.monark.hybrid.PageObjectsWeb;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.mastek.monark.hybrid.BaseSetup.BaseClass;
import com.mastek.monark.hybrid.Core.ElementAction;
import com.mastek.monark.hybrid.Reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BaseClass{
	
	
	ElementAction action = new ElementAction();
	
	
	public HomePage() {
		
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchInput']")
	WebElement txt_SearchBox;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement btn_Submit;
	

	public void searchForContent(String value) throws IOException {
		
		try {			
						
//			txt_SearchBox.sendKeys(ExcelHandling.Get_Data(TC_ID, "NewField"));
						
			System.out.println(ExtentTestManager.getTest().toString());
			
			action.enterText(driver, txt_SearchBox, value, "SearchBox");
			
			action.clickElement(driver, btn_Submit, "Submit button");
			
//			btn_Submit.click();		
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Searched for text successfully");
			
			ExtentTestManager.takeScreenshot(driver, "sample message for snapshot");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


}
