package com.mastek.monark.hybrid.Core;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mastek.monark.hybrid.Reporting.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @description A generic Wrapper methods library for the Selenium WebDriver API
 * @version 0.9
 *  
 * @author Ravi14222
 *
 */

public class ElementAction {
	
			
	public boolean isElementDisplayed(ThreadLocal<RemoteWebDriver> driver, WebElement element,String elementName) throws InterruptedException, IOException
	{
		try
		{
			element.isDisplayed();
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" Exist");
		}
		catch(Throwable t)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			
//			t.printStackTrace();
			return false;
		}
		return true;
	}


	public void clickElement(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
		
			element.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" Clicked");
		}
		catch(Throwable t)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
//			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	

	
	public void enterText(ThreadLocal<RemoteWebDriver> driver, WebElement element,String value,String elementName) throws Exception
	{
		try
		{
			element.clear();
			element.sendKeys(value);
			element.click();
			
			ExtentTestManager.getTest().log(LogStatus.PASS,value + " entered in "+ elementName);
		}
		 catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
//			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	
	
	public void enterTextByMoveToElement(ThreadLocal<RemoteWebDriver> driver, WebElement element, String value,String elementName) throws Exception {
		Actions actions = new Actions(driver.get());
		try
		{

			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(value);
			actions.build().perform();
			ExtentTestManager.getTest().log(LogStatus.PASS,value + " entered in "+ elementName);
		}  catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
//			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	

	public void selectCheckBox(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{	
			
			element.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" checkbox clicked");
		}  catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
//			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void selectRadio(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{	
			
			element.click();
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" checkbox clicked");
		}  catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
//			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getInputTextValue(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			String a= element.getAttribute("value");
			System.out.println(a);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" has "+ element.getAttribute("value"));
			return element.getText();
		}
		 catch(Throwable t)
			{ 
			 	ExtentTestManager.getTest().log(LogStatus.FAIL,element+" does not Exist");
//				t.printStackTrace();
			 	ExtentTestManager.takeScreenshot(driver, "Step Failed:");
				throw new Exception("Element Not Present");
			}
	}
		
	
	
	public void clearInputTextValue(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			element.clear();
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}
	
	
	public void selectDropDownByVisibleText(ThreadLocal<RemoteWebDriver> driver, WebElement element,String value, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			select.selectByVisibleText(value);

			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}

	}
	
		
	public void selectDropDownByValue(ThreadLocal<RemoteWebDriver> driver, WebElement element,String value, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			select.selectByValue(value);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}

	}
	
	
	public void selectDropDownByIndex(ThreadLocal<RemoteWebDriver> driver, WebElement element,int index, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			select.selectByIndex(index);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" selected with index "+index);
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}

	}
	
	
	public void selectDropDownByDefaultValue(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			select.selectByIndex(0);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" selected with default value ");
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}

	}
	
	
	public String getDropDownDefaultValue(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			ExtentTestManager.getTest().log(LogStatus.PASS, elementName+" selected value is "+select.getFirstSelectedOption().getText());
			return select.getFirstSelectedOption().getText();
			
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}
	
	public String getDropDownSelectedValue(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" selected value is "+select.getFirstSelectedOption().getText());
			return select.getFirstSelectedOption().getText();
		}
	
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}

	public int getDropDownSize(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		try
		{
			
			Select select = new Select(element);
			ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" dropbox size is "+select.getOptions().size());
			return select.getOptions().size();
		}
		catch(Throwable t)
		{ 
			ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
			ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}

	public List<WebElement> getDropDownOptions(ThreadLocal<RemoteWebDriver> driver, WebElement element, String elementName) throws Exception
	{
		List<WebElement> elementCount = null;
	    try
		{
	    	Select oSelect = new Select(element);
	    	element.click();
	    	elementCount = oSelect.getOptions();
	        System.out.println(elementCount);
	       
	        ExtentTestManager.getTest().log(LogStatus.PASS,elementName+"Dropdown values are Displayed");
			
		}
	    catch(Throwable t)
		{ 
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+"Dropdown values are Displayed");
	    	ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			
		}
	    
	    return elementCount;
	}



	public void mouseHoverAction_3(ThreadLocal<RemoteWebDriver> driver,WebElement mainElement, WebElement subElement,WebElement subSubElement,String elementName) throws Exception{
        try
        {
			Actions action = new Actions(driver.get());
			action.moveToElement(mainElement).perform();
			action.moveToElement(subElement).perform();
			action.moveToElement(subSubElement);
			action.click();
			action.perform();
			ExtentTestManager.getTest().log(LogStatus.PASS,"Click action is performed on the selected Product Type"+elementName);
	     }
        catch(Throwable t)
		{ 
        	ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
        	ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}
	
	public void mouseHoverAction_2(ThreadLocal<RemoteWebDriver> driver,WebElement mainElement, WebElement subElement,String elementName) throws Exception{
      try
      {
		Actions action = new Actions(driver.get());
		action.moveToElement(mainElement).perform();
		action.moveToElement(subElement);
		action.click();
		action.perform();
		ExtentTestManager.getTest().log(LogStatus.PASS,"Click action is performed on the selected Product Type"+elementName);
    }
   catch(Throwable t)
	{ 
	   	ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//		t.printStackTrace();
	   	ExtentTestManager.takeScreenshot(driver, "Step Failed:");
		throw new Exception("Element Not Present");
	}
	}
	
	
	public void mouseHoverAction(ThreadLocal<RemoteWebDriver> driver,WebElement mainElement,String elementName) throws Exception{
      try
      {
		Actions action = new Actions(driver.get());
		action.moveToElement(mainElement).clickAndHold().build().perform();
		action.release().perform();
	//action.perform();
		ExtentTestManager.getTest().log(LogStatus.PASS,"Click action is performed on the selected Product Type"+elementName);
    }
   catch(Throwable t)
	{ 
	   	ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//		t.printStackTrace();
	   	ExtentTestManager.takeScreenshot(driver, "Step Failed:");
		throw new Exception("Element Not Present");
	}
	}
	
	
	public void mouseHover(ThreadLocal<RemoteWebDriver> driver,WebElement mainElement,String elementName) throws Exception{
	      
		try
	      {
	    	
	    	  
			Actions action = new Actions(driver.get());
			action.moveToElement(mainElement).perform();
			ExtentTestManager.getTest().log(LogStatus.PASS,"Mouse Hover to "+elementName);
	    }
	   catch(Throwable t)
		{ 
		   ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
		   ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}
		
	
	public void mouseHoverAction_4(ThreadLocal<RemoteWebDriver> driver,WebElement mainElement, WebElement subElement,WebElement subSubElement, WebElement subBesideElement,String elementName) throws Exception{
	    try
	    {
			Actions action = new Actions(driver.get());
	
			action.moveToElement(mainElement).perform();
			action.moveToElement(subElement).perform();
			action.moveToElement(subSubElement).perform();
			action.moveToElement(subBesideElement).perform();
			action.click();
			action.perform();
			ExtentTestManager.getTest().log(LogStatus.PASS,"Click action is performed on the selected Product Type"+elementName);
	    }
	   catch(Throwable t){ 
		    ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//			t.printStackTrace();
		    ExtentTestManager.takeScreenshot(driver, "Step Failed:");
			throw new Exception("Element Not Present");
		}
	}
	
		
	public String getWindowHandle(ThreadLocal<RemoteWebDriver> driver, String browserTitle) throws IOException {
		
		try {
			Set<String> handles = driver.get().getWindowHandles();
	
			String[] browser =	handles.toArray(new String[0]);
			System.out.println("Number of browsers opened are"
					+ browser.length);
			for (int i=0; i<handles.size();i++) {
	
				driver.get().switchTo().window(browser[i]);
				if(driver.get().getTitle().equals(browserTitle)){
					return driver.get().getWindowHandle();
				
				}
	
			}
		}catch(Throwable t) {
			 ExtentTestManager.takeScreenshot(driver, "Step Failed:");
		}
		return browserTitle;

	} 
	
		
	public void waitForElementNotPresent(ThreadLocal<RemoteWebDriver> driver, String elementXpath) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath)));
		} catch (Exception te) {
			 ExtentTestManager.takeScreenshot(driver, "Step Failed:");
		}
	}
	
	public void waitForElementVisible(ThreadLocal<RemoteWebDriver> driver, String elementXpath) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
		} catch (Exception e) {
			 ExtentTestManager.takeScreenshot(driver, "Step Failed:");
		} 
	}
	
	public void waitForElementClickable(ThreadLocal<RemoteWebDriver> driver, String elementXpath) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
		} catch (Exception e) {
			
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			
		} 
	}
	
	
	public void waitForPageToLoad(ThreadLocal<RemoteWebDriver> driver) {
		driver.get().manage().timeouts().implicitlyWait(Integer.parseInt("40"), TimeUnit.SECONDS);
	}

	
	
	public void doubleClick(ThreadLocal<RemoteWebDriver> driver, WebElement elementName) throws Exception
	{
		try {
			Actions action = new Actions(driver.get());
			action.moveToElement(elementName);
			Thread.sleep(2000);
			action.doubleClick();
			//action.doubleClick(myElemment);
			action.build().perform();
		}catch(Exception e) {
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			throw new Exception("selectDropBoxValue() --- >Element Not Present");
		}
	}
	

	
	public void acceptAlert(ThreadLocal<RemoteWebDriver> driver) throws InterruptedException, IOException {
		try {
			Alert alert = waitforAlertPresent(driver);
			if (!alert.equals(null))
				alert.accept();
		} catch (Throwable ex) {
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		}
	}
	
	public boolean isAlertdisplayed(ThreadLocal<RemoteWebDriver> driver) throws InterruptedException, IOException {
		try {
			Alert alert = waitforAlertPresent(driver);
			System.out.println("alert present");
			if (!alert.equals(null))
				driver.get().switchTo().alert();
			driver.get().switchTo().alert();
			
			
			Alert myAlert = driver.get().switchTo().alert();
			
			String s=myAlert.getText();
			Thread.sleep(2000);
			System.out.println(s);
			
			String ab[]=s.split(":");
		    
		    
		     for(int i=0;i<ab.length;i++)
		     {
		    	 
		    	 ExtentTestManager.getTest().log(LogStatus.PASS,"Alert/Popup message is dispalyed as :");
		    	 ExtentTestManager.getTest().log(LogStatus.PASS,ab[i] );
		    	 
		     }
		     return true;
		} catch (Throwable t) {
			waitForPageToLoad(driver);
			
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Alert does not Exist");
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			return false;
		}
	}
	
	
	public Alert waitforAlertPresent(ThreadLocal<RemoteWebDriver> driver) throws InterruptedException {
		int i = 0;
		Alert alert = null;
		while (i++ < 30) {
			try {
				alert = driver.get().switchTo().alert();
				return alert;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return alert;
	}
	
	
	public void waitForPopUp(ThreadLocal<RemoteWebDriver> driver, String b) throws InterruptedException, IOException {
		Thread.sleep(3000);
		try {
			selectWindowPopUp(driver, b);
			driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		}
	}
	
	public void selectWindowPopUp(ThreadLocal<RemoteWebDriver> driver, String arg) throws IOException {
		boolean flag = false;
		try {
			for (int i = 0; i < 2 && flag == false; i++) {
				Set<String> pops = driver.get().getWindowHandles();
					Iterator<String> it = pops.iterator();
					if (pops.size() > 1) {
						System.out.println("No of Windows " + pops.size());
						for (int j = 0; j < pops.size() && flag == false; j++) {
							String popupHandle = it.next().toString();
							if (driver.get().switchTo().window(popupHandle).getTitle().contains(arg)) {
								driver.get().switchTo().window(popupHandle);
								flag = true;
							}
						}flag = true;
						pops.clear();
					}
			}
		} catch (Exception e) {
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		}
	}
	
	

	public void waitForFrameAndSwitch(ThreadLocal<RemoteWebDriver> driver, String frameName) throws IOException {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(),60);
			driver.get().switchTo().defaultContent();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		}catch (Exception e) {
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		}
		
	}
	public void waitForElementVisible(ThreadLocal<RemoteWebDriver> driver, String elementXpath,String elementName) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver.get(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
		} 
		 catch (Throwable we) {
//			 we.printStackTrace();
			 ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			 ExtentTestManager.getTest().log(LogStatus.FAIL, elementName+"Not visible");
		}
	}
	
	
public void JavascriptexecutorForClickInsideFrame(ThreadLocal<RemoteWebDriver> driver, String frameName,String elementXpath,String elementName) throws Throwable {
	waitForPageToLoad(driver);
	waitForFrameAndSwitch(driver, frameName);
	waitForPageToLoad(driver);
	waitForElementVisible(driver, elementXpath,elementName);
	try
	{	
		WebElement e=driver.get().findElement(By.xpath(elementXpath));
		JavascriptExecutor js = (JavascriptExecutor)driver.get();
		
		js.executeScript("arguments[0].click();", e);
		ExtentTestManager.getTest().log(LogStatus.PASS, elementName+" Clicked");
		js=null;

	}
	catch(Throwable t)
	{
	
		ExtentTestManager.getTest().log(LogStatus.FAIL, elementName+" Not Present");
//		t.printStackTrace();
		ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		new Exception(elementName+" not present");
	}

	
}


public void JavascriptexecutorForClick(ThreadLocal<RemoteWebDriver> driver, WebElement element,String elementName) throws Throwable {

	try
	{	
		
		JavascriptExecutor js = (JavascriptExecutor)driver.get();
		
		js.executeScript("arguments[0].click();", element);
		ExtentTestManager.getTest().log(LogStatus.PASS, elementName+" Clicked");
		js=null;

	}
	catch(Throwable t)
	{
	
		ExtentTestManager.getTest().log(LogStatus.FAIL, elementName+" Not Present");
//		t.printStackTrace();
		ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		new Exception(elementName+" not present");
	}

	
}

public void clickElementByPartialLinkText(ThreadLocal<RemoteWebDriver> driver,String linkText,String elementName) throws Exception
{
    try
	{
		WebElement webButton = driver.get().findElement(By.partialLinkText(linkText));
		webButton.click();
		ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" Clicked");
	}
    catch(Throwable t)
	{ 
    	ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//		t.printStackTrace();
    	ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		throw new Exception("Element Not Present");
	}
}



	public boolean checkElementClickable(ThreadLocal<RemoteWebDriver> driver, String elementXpath,String elementName) throws InterruptedException, IOException {
	try {
		
	    driver.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver.get(), 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
		ExtentTestManager.getTest().log(LogStatus.PASS, elementName+" Element is clickable");
		waitForPageToLoad(driver);
		return true;
	} catch (Throwable e) {
		waitForPageToLoad(driver);
		ExtentTestManager.getTest().log(LogStatus.FAIL, elementName+" Element is not clickable");
		ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		return false;
	} 
	}
		
	
	public void elementHighlight(ThreadLocal<RemoteWebDriver> driver,WebElement element) throws IOException {
		
		try {
			for (int i = 0; i < 4; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver.get();
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 3px solid red;");
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
				
			}
		}catch(Exception e) {
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
		}
		
	}
	
	

	public boolean isElementEnabled(ThreadLocal<RemoteWebDriver> driver, WebElement element,String elementName) throws IOException
	{
		boolean flag=false;
		try
		{
			if(element.isEnabled())
			{	
				ExtentTestManager.getTest().log(LogStatus.PASS, elementName +" is enabled ");
				flag = true;
			}
		}
		catch(Throwable e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, elementName +" is not enabled ");
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			flag = false;
		}
		return flag;

	}
	
	public boolean isElementDisabled(ThreadLocal<RemoteWebDriver> driver, WebElement element,String elementName) throws IOException
	{
		boolean flag=false;
		try
		{
			if(element.isEnabled())
			{	
				ExtentTestManager.getTest().log(LogStatus.FAIL, elementName +" is enabled");
				flag = false;
			}
		}
		catch(Throwable e)
		{
			ExtentTestManager.getTest().log(LogStatus.PASS, elementName +" not enabled ");
			
			ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
			
			flag = true;
		}
		return flag;

	}
	
	
	public String getAttribute(ThreadLocal<RemoteWebDriver> driver, WebElement element,String attributeName,String elementName) throws Exception
	  {
	    try
	    {
	      
	      ExtentTestManager.getTest().log(LogStatus.PASS,elementName+" has "+ element.getText());
	      return element.getAttribute(attributeName);
	    }
	     catch(Throwable t)
	      { 
	    	 ExtentTestManager.getTest().log(LogStatus.FAIL,elementName+" does not Exist");
//	        t.printStackTrace();
	    	 ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
	        throw new Exception("Element Not Present");
	      }
	  }
	

	public void waitForPageToLoadJavascript(ThreadLocal<RemoteWebDriver> driver, String elementName) throws Throwable {

        try
        {      
               
               until(driver, (d) ->
               {
                     Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                     if (!isPageLoaded) System.out.println("Document is loading...");
                     return isPageLoaded;
               }, 30);

        }
        catch(Throwable t)
        {
        
               ExtentTestManager.getTest().log(LogStatus.FAIL, elementName+" Page loading issue..");
//             t.printStackTrace();
               ExtentTestManager.takeScreenshot(driver, "Step Failed: ");
               new Exception(elementName+" not present");
        }
        
 }
	
	
	public static void until(ThreadLocal<RemoteWebDriver> driver, Function<ThreadLocal<RemoteWebDriver> , Boolean> waitCondition, int i){
		until(driver, waitCondition, i);
	}
	
	
	public static void waitForPageToLoadJQuery(ThreadLocal<RemoteWebDriver> driver, Long timeoutInSeconds){
		until(driver, (d) ->
			{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is In Progress...");
			return isJqueryCallDone;
			}, 30);
	}
	
}
	
	
	
	
	
	
	

	