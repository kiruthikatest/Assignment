package com.kaleidofin.amazon.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.kaleidofin.browser.modules.AmazonShoppingModule;
import com.kaleidofin.driver.ServerHandler;
import com.kaleidofin.test.enums.enumTestProperties;
import com.kaleidofin.util.Config;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

	protected static MobileDriver driver;
	protected static String LoginUserName;
	protected static String LoginPassword;
	
	protected static String platformname;
	protected static String devicename;
	protected static String Platformversion;
	protected static String browsername;
	protected static String apppackage;
	protected static String appactivity;
	protected static String chromedriverexecutable;
	
	protected static String SearchItem;
	
	protected static ServerHandler serverHandler;
	
	 protected static AmazonShoppingModule amazonshoppingModule;
	 
	 /*
	  * This method is to get the input from config file residing in resource folder
	  */
	@BeforeSuite
	public void InitializeVariables()
	{
		LoginUserName = System.getProperty(enumTestProperties.USERNAME
				.getValue(), Config.getInstance().getSetting("USERNAME"));
		
	
		LoginPassword = System.getProperty(enumTestProperties.PASSWORD
				.getValue(), Config.getInstance().getSetting("PASSWORD"));
		
		platformname = System.getProperty(enumTestProperties.PLATFORMNAME
				.getValue(), Config.getInstance().getSetting("PLATFORMNAME"));
		
		devicename = System.getProperty(enumTestProperties.DEVICENAME
				.getValue(), Config.getInstance().getSetting("DEVICENAME"));
		
		Platformversion = System.getProperty(enumTestProperties.PLATFORMVERSION
				.getValue(), Config.getInstance().getSetting("PLATFORMVERSION"));
		
		browsername = System.getProperty(enumTestProperties.BROWSERNAME
				.getValue(), Config.getInstance().getSetting("BROWSERNAME"));
		
		apppackage = System.getProperty(enumTestProperties.APPPACKAGE
				.getValue(), Config.getInstance().getSetting("APPPACKAGE"));
		
		appactivity = System.getProperty(enumTestProperties.APPACTIVITY
				.getValue(), Config.getInstance().getSetting("APPACTIVITY"));
		
		
		SearchItem =  System.getProperty(enumTestProperties.ITEMTOSEARCH
				.getValue(), Config.getInstance().getSetting("SEARCHITEM"));
		
		
		System.out.println(LoginUserName +LoginPassword +  platformname+ appactivity);
		initsetup();
		
		createDriver();
		
		initializescripts();
		
		
		
	}
	
	
	/*
	 * Start Appium Server method
	 */
	private void initsetup() {
		// TODO Auto-generated method stub
		serverHandler = new ServerHandler();
		serverHandler.startServer();
		
	}

	/*
	 * Create driver instance
	 */
	public static void createDriver()
	{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", platformname);
		capabilities.setCapability("deviceName",devicename );
		capabilities.setCapability("platformVersion", Platformversion);
		capabilities.setCapability("browserName", browsername);
		// capabilities.setCapability("app", "app-debug.apk");
		capabilities.setCapability("appPackage", apppackage);
		capabilities.setCapability("appActivity", appactivity);
		
		capabilities.setCapability("automationName", "UiAutomator2");
		
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initializescripts()
	{
		
		amazonshoppingModule = new AmazonShoppingModule(driver);
	}
	
	protected void QuitMobileDriver() {
		
		if (driver != null)
			driver.quit();
	}
	
	@AfterSuite
	protected void CloseMobileDriver() {
		
		if (driver != null)
			driver.quit();
		
		serverHandler.stopServer();
		
		
	}
	
}
