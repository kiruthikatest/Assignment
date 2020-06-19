package com.kaleidofin.browser.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class SampleTest {

	public static void main(String[] arg) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Galaxy M30s39FD");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("browserName", "");
		// capabilities.setCapability("app", "app-debug.apk");
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\kiruthika_p\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		
		capabilities.setCapability("automationName", "UiAutomator2");
		
	MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		
		  Thread.sleep(5*1000);
		  
		  TakeScreenshot(driver,"UserAskedtoSignIn");
		
		
		  driver.findElement(By.id("in.amazon.mShop.android.shopping:id/sign_in_button")).click(); Thread.sleep(2*1000);
		  
		  driver.findElementByClassName("android.widget.EditText").sendKeys("kiruthika904@gmail.com");
		  
		  
		  Thread.sleep(5 * 1000);
		  
		  
		  WebElement e = driver.findElementByClassName("android.widget.Button");
		  if(e.getText().contains("Continue")) e.click();
		  
		  Thread.sleep(5 * 1000);
		  
		  driver.findElementByClassName("android.widget.EditText").sendKeys("jithu904");
		  
		  WebElement e1 = driver.findElementByClassName("android.widget.Button");
		  if(e1.getText().contains("Login")) e1.click();
		  
		  Thread.sleep(5 * 1000);
		  
		  TakeScreenshot(driver,"LogInSuccessful");
		 
		/* Till this login */
		
		  WebElement e2 = driver.findElementByClassName("android.widget.Button");
			  if(e2.getText().contains("Continue")) e2.click();
			  
			  Thread.sleep(5 * 1000);
			  
			  driver.findElementById("rs_search_src_text").click();
			 
			  Thread.sleep(5 * 1000);
			  
			  driver.findElementById("rs_search_src_text").sendKeys("IPhone");
			  
			  ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		  
		  
		  
		  Thread.sleep(15*1000);
		  
		  TakeScreenshot(driver,"ListOfIphonesReturned");
		  
		  List<WebElement> listofiphones = driver.findElementsById("in.amazon.mShop.android.shopping:id/item_title");
		  
		  listofiphones.get(3).click();
		  
		  TakeScreenshot(driver,"4thIphoneSelectedfromtheList");
		  
		  scrollByText("Add to Cart", driver).click();
		  
		  TakeScreenshot(driver,"AddingtoCart");

		  int crtcount = Integer.parseInt( driver.findElementById("in.amazon.mShop.android.shopping:id/action_bar_cart_count").getText());
		  
		  TakeScreenshot(driver,"CartCountChanged");
		  
		  System.out.println(crtcount);
		  
		  if(crtcount >=1)
		  {
			  driver.findElementById("in.amazon.mShop.android.shopping:id/action_bar_cart").click();
			  
			  TakeScreenshot(driver,"IphoneAddedtoCart");
			  
			  
		  }
		  
		  
		
		  
	}
	
	public static void switchtowebview(AppiumDriver driver)
	{
		  Set<String> contextNames = driver.getContextHandles(); for(String context :
			  contextNames) { 
			  System.out.println(context);
			  if(context.toLowerCase().contains("web")){
				  driver.context(context);
			  
			  break; }}
	}
	
	public static void switchtoNativeView(AppiumDriver driver)
	{
		driver.context("NATIVE_APP");
	}
	
	public static WebElement scrollByText(String menuText, MobileDriver driver) {

        try {

             return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + menuText + "\").instance(0));")); 
        } catch (Exception e) {
           e.printStackTrace();
        }
		return null;
    }
	
	public static boolean tapElement(AppiumDriver driver, WebElement elem)
	{
		elem.click();
		return true;
		
	}
	
	public static void TakeScreenshot(MobileDriver driver, String Filename)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File directory = new File(".//output");
	    if (! directory.exists()){
	        directory.mkdir();
	    }
		
	    File dest = new File(".//output/" + Filename + ".png");
	    
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
