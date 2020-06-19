package com.kaleidofin.test.enums;

public enum enumTestProperties {

	USERNAME("username"),
	PASSWORD("password"),
	ITEMTOSEARCH("searchitem"),
	PLATFORMNAME("platformName"),
	DEVICENAME("deviceName"), 
	PLATFORMVERSION("platformVersion"), 
	BROWSERNAME("browserName"), 
	APPPACKAGE("appPackage"),
	APPACTIVITY("appActivity"),
	CHROMEDRIVER("chromedriverExecutable");
	private String mValue;
	
	private enumTestProperties(String value) {
        this.setmValue(value);
    }

    /**
     * @return mValue
     */
    public String getValue() {
        return mValue;
    }

    /**
     * @param mValue
     *            the value to set
     */
    public void setmValue(String value) {
        this.mValue = value;
    }
}
