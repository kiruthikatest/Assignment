package com.kaleidofin.browser.modules;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.kaleidofin.browser.pages.AmazonShoppingAppConstants;
import com.kaleidofin.util.CaptureScreenshot;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class AmazonShoppingModule {

	MobileDriver driver;
	
	protected AmazonShoppingAppConstants amazonapppage;
	protected CaptureScreenshot capturescreen;
	
	public AmazonShoppingModule(MobileDriver driver)
	{
		this.driver = driver;
		amazonapppage = new AmazonShoppingAppConstants(driver);
		capturescreen = new CaptureScreenshot(driver);
	}
	
	public void clickAlreadyCustomerSignInOption()
	{
		amazonapppage.getSignInelement().click();
	}
	public void EditTextUsername_Password(String username_password)
	{
		amazonapppage.getclassEditTextElement().sendKeys(username_password);
	}
	
	public void clickContinueButton()
	{
		String btntext;
		WebElement e;
		e = amazonapppage.getclassButtonElement();
		btntext = e.getText();
		if(btntext.contains(amazonapppage.TEXT_BUTTON_CONTINUE))
		{
			e.click();
		}
	}
	
	public void clickLoginButton()
	{
		String btntext;
		WebElement e;
		e = amazonapppage.getclassButtonElement();
		btntext = e.getText();
		if(btntext.contains(amazonapppage.TEXT_BUTTON_LOGIN))
		{
			e.click();
		}
	}
	
	public void ClickSearchEditTextElement()
	{
		amazonapppage.getSearchTextelement().click();
	}
	
	public void EnterItemtoSearch(String searchtext)
	{
		amazonapppage.getSearchTextelement().click();
		waitforpageload(5);
		amazonapppage.getSearchTextelement().sendKeys(searchtext);
		PressEnterKey();
	}
	
	public void PressEnterKey()
	{
		 ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void clickonItembyIndex(int index)
	{
		amazonapppage.getItemTitleListofelements().get(index).click();
	}
	
	public void clickAddtocartAfterScroll()
	{
		amazonapppage.scrollByText().click();
	}
	
	public int getCartCount()
	{
		
		return Integer.parseInt(amazonapppage.getCartCountElement().getText());
	}
	
	public void clickoncart()
	{
		amazonapppage.getCartElement().click();
	}
	
	public void takeScreenshot(String Filename)
	{
		capturescreen.TakeScreenshot(Filename);
	}
	
	public String getGreetingsText()
	{
		return amazonapppage.getGreetingtext().getText();
	}
	
	public boolean verifyLoginSuccessful()
	{
		System.out.println(getGreetingsText());
		if(getGreetingsText().contains("Hello"))
		{
			return true;
		}
		return false;
	}
	
	public String getItemtitle(int index)
	{
		return amazonapppage.getItemTitleListofelements().get(index).getText();
	}
	public boolean checkforanitemincart(String item)
	{
		//System.out.println(driver.getPageSource());
		List<WebElement> e = amazonapppage.getClassTextViewElement();
		for(WebElement e1 : e)
		{
			if(e1.getText().equals(item))
				return true;
			
		}
		return false;
	}
	public void openSidemenu()
	{
		amazonapppage.getSideMenu().click();
	}
	
	
	public boolean checkforiteminthepage(String item)
	{
		return amazonapppage.checkfortext(item);
	}
	
	public void waitforpageload(int milliseconds)
	{
		try {
			Thread.sleep(milliseconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
