package com.kaleidofin.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileDriver;

public class CaptureScreenshot {
	
	protected static MobileDriver driver;
	
	static String outputfilepath = ".//output/";
	
	public CaptureScreenshot(MobileDriver driver)
	{
		this.driver = driver;
	}
	
	
	public static void TakeScreenshot( String Filename)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File directory = new File(outputfilepath);
	    if (! directory.exists()){
	        directory.mkdir();
	    }
		
	    File dest = new File(outputfilepath + Filename + ".png");
	    
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
