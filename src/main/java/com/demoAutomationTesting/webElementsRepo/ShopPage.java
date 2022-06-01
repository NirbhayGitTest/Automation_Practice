package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoAutomationTesting.genericLibrary.SeleniumWebDriverLibrary;

public class ShopPage {
	
	@FindBy(linkText = "Home")
	private WebElement homeLink;
	
	@FindBy(xpath="//div[@id='content']")
	private WebElement shopHeader;

	
	//initialize the driver address to all the elements through constructors and make it as public
	
	public ShopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//business library
	
	public void clickHomeLink(SeleniumWebDriverLibrary seleniumLibrary)
	{
		homeLink.click();
	}
	
	public WebElement headerShop()
	{
		return shopHeader;
	}

}
