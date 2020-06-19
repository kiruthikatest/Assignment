package com.kaleidofin.browser.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kaleidofin.amazon.base.BaseTest;

public class AmazonAppTestScript extends BaseTest {
	
	
	
	@Test
	public void logintoAmazonApp()
	{
		
		
		  System.out.println("Create driver instance"); BaseTest.createDriver();
		  
		  
		  
		  System.out.println("Click on signin element");
		  amazonshoppingModule.clickAlreadyCustomerSignInOption();
		  
		  System.out.println("Login with username/password");
		  amazonshoppingModule.EditTextUsername_Password(LoginUserName);
		  amazonshoppingModule.clickContinueButton();
		  
		  amazonshoppingModule.waitforpageload(5);
		  
		  amazonshoppingModule.EditTextUsername_Password(LoginPassword);
		  amazonshoppingModule.waitforpageload(3);
		  amazonshoppingModule.clickLoginButton();
		  
		  System.out.println("Verify Login successful");
		  amazonshoppingModule.takeScreenshot("Login");
		  
		  
		  
		  System.out.println("Verify Login successful");
		  amazonshoppingModule.openSidemenu();
		  
		  amazonshoppingModule.takeScreenshot("SideMenu");
		  Assert.assertTrue(amazonshoppingModule.verifyLoginSuccessful(),
		  "Login attempt failed");
		 }
	
	@Test(dependsOnMethods = {"logintoAmazonApp"})
	public void AddItemtoCart()
	{	
		  System.out.println("Search for - IPhone");
		  amazonshoppingModule.EnterItemtoSearch(SearchItem);
		  
		  amazonshoppingModule.waitforpageload(10);
		  amazonshoppingModule.takeScreenshot("ListedIphones");
		  
		  String itemaddtocart = amazonshoppingModule.getItemtitle(3); int
		  initialcartcount = amazonshoppingModule.getCartCount();
		  
		  System.out.println("InitialCartCount :: " + initialcartcount
		  +", Addeditem :: " + itemaddtocart);
		  
		  System.out.println("Select item");
		  amazonshoppingModule.clickonItembyIndex(3);
		  amazonshoppingModule.waitforpageload(5);
		  
		  
		  amazonshoppingModule.takeScreenshot("SelectedIphone");
		  
		  System.out.println("Add item to cart");
		  amazonshoppingModule.clickAddtocartAfterScroll();
		  
		  amazonshoppingModule.waitforpageload(5);
		  
		  System.out.println("Verify item added to cart");
		  amazonshoppingModule.takeScreenshot("CartCount");
		  System.out.println("currentcartcount :: "+amazonshoppingModule.getCartCount()
		  ); Assert.assertTrue(amazonshoppingModule.getCartCount() > initialcartcount,
		  "Item Add to Cart failed");
		 
		
		
		System.out.println("Open cart and capture");
		amazonshoppingModule.clickoncart();
		amazonshoppingModule.takeScreenshot("Cart");
		amazonshoppingModule.waitforpageload(5);
		Assert.assertTrue(amazonshoppingModule.checkforanitemincart(itemaddtocart), "Added Item is not listed");
		
	}

}
