package com.kaleidofin.browser.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;

public class AmazonShoppingAppConstants {
	
	MobileDriver driver;
	
	private static final String ID_SIGN_IN = "sign_in_button";
	
	private static final String ID_SEARCH_TEXT = "rs_search_src_text";

	public static final String TEXT_BUTTON_LOGIN = "Login";

	public static final String TEXT_BUTTON_CONTINUE = "Continue";

	private static final String CLASS_ANDROID_EDITTEXT = "android.widget.EditText";
	
	private static final String CLASS_ANDROID_BUTTON = "android.widget.Button";
	
	private static final String CLASS_TEXT_VIEW = "android.widget.TextView";
	private static final String ID_ITEM_TITLE = "item_title";
	
	private static final String ID_CART_COUNT = "action_bar_cart_count";
	
	private static final String ID_GREETINGS_TEXT="gno_greeting_text_view";
	
	private static final String ID_CART_ELEMENT = "action_bar_cart";
	
	private static final String ID_SIDEMENU_ELEMENT = "action_bar_burger_icon";
	
	private static final String TEXT_ADDTOCART_ELEMENT = "Add to Cart";
	
	
	
	public AmazonShoppingAppConstants(MobileDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebElement getSignInelement()
	{
		return driver.findElementById(ID_SIGN_IN);
	}
	
	
	public WebElement getSearchTextelement()
	{
		return driver.findElementById(ID_SEARCH_TEXT);
	}

	public WebElement getclassButtonElement()
	{
		return driver.findElementByClassName(CLASS_ANDROID_BUTTON);
	}
	
	public WebElement getclassEditTextElement()
	{
		return driver.findElementByClassName(CLASS_ANDROID_EDITTEXT);
	}
	
	public List<WebElement> getItemTitleListofelements()
	{
		return driver.findElementsById(ID_ITEM_TITLE);
	}
	
	public WebElement getCartCountElement()
	{
		return driver.findElementById(ID_CART_COUNT);
	}
	
	public WebElement getCartElement()
	{
		return driver.findElementById(ID_CART_ELEMENT);
	}
	
	public WebElement scrollByText()
	{
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
				+ "instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + TEXT_ADDTOCART_ELEMENT + "\").instance(0));"));
	}
	
	public WebElement getGreetingtext()
	{
		return driver.findElementById(ID_GREETINGS_TEXT);
	}
	
	public WebElement getSideMenu()
	{
		return driver.findElementById(ID_SIDEMENU_ELEMENT);
	}
	
	public boolean checkfortext(String item)
	{
		return driver.findElementByName(item) != null;
	}


	public List<WebElement> getClassTextViewElement() {
		// TODO Auto-generated method stub
		return driver.findElementsByClassName(CLASS_TEXT_VIEW);
	}
}
