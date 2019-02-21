package com.mastek.monark.hybrid.BaseSetup;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.mastek.monark.hybrid.Core.Paths;

public class BaseClass {
	
	
	//Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public DesiredCapabilities capabilities;
    public static String TC_ID =null;
 
    @BeforeClass
    @Parameters({ "browserType", "appURL","tcID" })
    public void setupTest(String browserType, String appURL,String tcID) throws MalformedURLException {
    	
    	
        //Set DesiredCapabilities
    	capabilities = new DesiredCapabilities();
         
        switch(browserType) {
        
	       case "Web-IE":
	           driver = initIEDriver(appURL);
	           break;
	       case "Web-Chrome":
	           driver = initChromeDriver(appURL);
	           break;           
	          
    
        }     

        TC_ID = tcID; 
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
        driver.get().manage().window().maximize();
        driver.get().get(appURL);
		
        
    }
 
    private ThreadLocal<RemoteWebDriver> initChromeDriver(String appURL) throws MalformedURLException {
    	
    	System.setProperty("webdriver.chrome.driver", Paths.drivers+"chromedriver.exe");
        
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS); 
        
        return driver;
		
	}

	private ThreadLocal<RemoteWebDriver> initIEDriver(String appURL) throws MalformedURLException {
		
    	System.setProperty("webdriver.ie.driver", Paths.drivers+"IEDriverServer.exe");
        
        capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        capabilities.setCapability("nativeEvents", false);    
        capabilities.setCapability("unexpectedAlertBehaviour", "accept");
        capabilities.setCapability("ignoreProtectedModeSettings", true);
        capabilities.setCapability("disable-popup-blocking", true);
        capabilities.setCapability("enablePersistentHover", true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setJavascriptEnabled(true);  
    	
 		return driver;
	}

	public WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }
 
    @AfterClass
    public void tearDown() throws Exception {
        
    	getDriver().close();
    	getDriver().quit();
        driver.remove();
    }
 

	
	
	
	
	
	
	
	
	
	
	
	
	/*
private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
public WebDriverWait wait;
public String TC_ID=null;
	

	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://10.0.0.6:4444/wd/hub"), getBrowserCapabilities(browser));
	}


	
	
	
	
	public void setDriver(String browserType, String appURL) {
		
//		wait = new WebDriverWait(driver, 20);
	
       switch(browserType) {
       
	       case "Web-IE":
	           driver = initIEDriver(appURL);
	           break;
	       case "Web-Chrome":
	           driver = initChromeDriver(appURL);
	           break;
	       case "Web-Firefox":
	    	   driver = initFirefoxDriver(appURL);
			   break;
	       case "Web-Edge":
	    	   driver = initFirefoxDriver(appURL);
	    	   break;
	       case "Mobile":
	           driver = initFirefoxDriver(appURL);
	           break;
	       case "Mobile-Chrome":
	           driver = initFirefoxDriver(appURL);
	           break;
	       case "Mobile-Safari":
	           driver = initFirefoxDriver(appURL);
	           break;
	       default:
	              System.out.println("Browser-Type : " + browserType
	                           + " provided is invalid, Launching Chrome Browser as default for execution!");
	              driver = initFirefoxDriver(appURL);
       }
       
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver initIEDriver(String appURL) {
       System.out.println("Launching Internet Explorer with new profile..");
       
       driver = new InternetExplorerDriver();
       
       DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
       cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
       cap.setCapability("nativeEvents", false);    
       cap.setCapability("unexpectedAlertBehaviour", "accept");
       cap.setCapability("ignoreProtectedModeSettings", true);
       cap.setCapability("disable-popup-blocking", true);
       cap.setCapability("enablePersistentHover", true);
       cap.setCapability("ignoreZoomSetting", true);
       cap.setJavascriptEnabled(true);  
       
       driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));
       driver = new InternetExplorerDriver(cap);
       driver.manage().window().maximize();
       driver.navigate().to(appURL);
       
       return driver;
	}
	
	private WebDriver initChromeDriver(String appURL) {
       System.out.println("Launching Google Chrome with new profile..");          
       
       System.setProperty("webdriver.chrome.driver", Paths.drivers+"chromedriver.exe");
       
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.navigate().to(appURL);
       return driver;
	}
	
	private WebDriver initFirefoxDriver(String appURL) {
       System.out.println("Launching Firefox browser..");
       driver = new FirefoxDriver();
       driver.manage().window().maximize();
       driver.navigate().to(appURL);
       return driver;
	}
	
	
	
	
	
	@Parameters({ "browserType", "appURL","tcID" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL,String tcID) {
       try {
              
          setDriver(browserType, appURL);
          TC_ID=tcID;

       } catch (Exception e) {
              System.out.println("Error....." + e.getStackTrace());
       }
	}
	
	@AfterClass
	public void tearDown() {
	     
		driver.quit();	       
	}
    

*/
}
