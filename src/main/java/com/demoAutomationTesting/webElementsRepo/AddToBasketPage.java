package com.demoAutomationTesting.webElementsRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToBasketPage {

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickonAddtoBasketBtn;
	
	public AddToBasketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonAddtoBasket(WebDriver driver)
	{
		
		clickonAddtoBasketBtn.click();
	}
	
}
